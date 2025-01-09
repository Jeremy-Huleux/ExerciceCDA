package com.exemple.apijpagenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class EntityGenerator {

    private final DatabaseConnector connector;
    private final String outputDir;
    private final String packageName;

    public EntityGenerator(DatabaseConnector connector, String outputDir, String packageName) {
        this.connector = connector;
        this.outputDir = outputDir;
        this.packageName = packageName;
    }

    public void generateEntities() throws Exception {
        List<String> tables = connector.getTables();
        for (String table : tables) {
            generateEntity(table);
        }
    }

    private void generateEntity(String tableName) throws Exception {
        Map<String, String> columns = connector.getColumns(tableName);
        String className = toPascalCase(tableName);
        String fileName = className + ".java";
        File outputFile = new File(outputDir, fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("package " + packageName + ";");
            writer.println();
            writer.println("import javax.persistence.*;");
            writer.println();
            writer.println("@Entity");
            writer.println("@Table(name = \"" + tableName + "\")");
            writer.println("public class " + className + " {");
            writer.println();

            for (Map.Entry<String, String> entry : columns.entrySet()) {
                String columnName = entry.getKey();
                String dataType = entry.getValue();
                String fieldName = toCamelCase(columnName);
                String javaType = mapSqlTypeToJavaType(dataType);

                writer.println("    @Column(name = \"" + columnName + "\")");
                if (columnName.equalsIgnoreCase("id")) {
                    writer.println("    @Id");
                    writer.println("    @GeneratedValue(strategy = GenerationType.IDENTITY)");
                }
                writer.println("    private " + javaType + " " + fieldName + ";");
                writer.println();
            }

            // Generate getters and setters
            for (Map.Entry<String, String> entry : columns.entrySet()) {
                String columnName = entry.getKey();
                String dataType = entry.getValue();
                String fieldName = toCamelCase(columnName);
                String javaType = mapSqlTypeToJavaType(dataType);

                // Getter
                writer.println("    public " + javaType + " get" + toPascalCase(fieldName) + "() {");
                writer.println("        return " + fieldName + ";");
                writer.println("    }");
                writer.println();

                // Setter
                writer.println("    public void set" + toPascalCase(fieldName) + "(" + javaType + " " + fieldName + ") {");
                writer.println("        this." + fieldName + " = " + fieldName + ";");
                writer.println("    }");
                writer.println();
            }

            writer.println("}");
        }
    }

    private String toPascalCase(String input) {
        StringBuilder result = new StringBuilder();
        for (String word : input.split("_")) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }
        return result.toString();
    }

    private String toCamelCase(String input) {
        String pascalCase = toPascalCase(input);
        return pascalCase.substring(0, 1).toLowerCase() + pascalCase.substring(1);
    }

    private String mapSqlTypeToJavaType(String sqlType) {
        switch (sqlType.toUpperCase()) {
            case "INT":
            case "INTEGER":
                return "Integer";
            case "BIGINT":
                return "Long";
            case "VARCHAR":
            case "CHAR":
            case "TEXT":
                return "String";
            case "DATE":
                return "java.sql.Date";
            case "TIMESTAMP":
                return "java.sql.Timestamp";
            case "BOOLEAN":
                return "Boolean";
            case "FLOAT":
                return "Float";
            case "DOUBLE":
                return "Double";
            default:
                return "Object";
        }
    }
}