package com.example.jpaentitygenerator;

import java.sql.*;
import java.util.*;

public class DatabaseService {

    private String getDriverClass(String databaseType) {
        switch (databaseType) {
            case "MySQL":
                return "com.mysql.cj.jdbc.Driver";
            case "PostgreSQL":
                return "org.postgresql.Driver";
            case "Oracle":
                return "oracle.jdbc.OracleDriver";
            default:
                throw new IllegalArgumentException("Unsupported database type: " + databaseType);
        }
    }

    public boolean testConnection(DatabaseConfig config) {
        try {
            Class.forName(getDriverClass(config.getDatabaseType()));
            try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<TableMetadata> getTableMetadata(DatabaseConfig config) throws SQLException {
        List<TableMetadata> tables = new ArrayList<>();

        try {
            Class.forName(getDriverClass(config.getDatabaseType()));
            try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword())) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet rs = metaData.getTables(config.getDatabaseName(), null, "%", new String[]{"TABLE"});

                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    TableMetadata table = new TableMetadata(tableName);

                    ResultSet columns = metaData.getColumns(null, null, tableName, null);
                    while (columns.next()) {
                        String columnName = columns.getString("COLUMN_NAME");
                        String dataType = columns.getString("TYPE_NAME");
                        boolean isNullable = columns.getInt("NULLABLE") == DatabaseMetaData.columnNullable;
                        table.addColumn(new ColumnMetadata(columnName, dataType, isNullable));
                    }

                    ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
                    while (primaryKeys.next()) {
                        String columnName = primaryKeys.getString("COLUMN_NAME");
                        table.addPrimaryKey(columnName);
                    }

                    ResultSet foreignKeys = metaData.getImportedKeys(null, null, tableName);
                    while (foreignKeys.next()) {
                        String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                        String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                        String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
                        table.addForeignKey(new ForeignKeyMetadata(fkColumnName, pkTableName, pkColumnName));
                    }

                    tables.add(table);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC driver not found", e);
        }

        return tables;
    }
}

