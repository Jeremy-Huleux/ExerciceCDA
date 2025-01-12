package com.example.jpaentitygenerator;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityGenerator {

    private static final Logger logger = LoggerFactory.getLogger(EntityGenerator.class);
    private final DatabaseService databaseService;
    private final EntityGeneratorConfig config;

    public EntityGenerator(EntityGeneratorConfig config) {
        this.databaseService = new DatabaseService();
        this.config = config;
    }

    public void generateEntities(DatabaseConfig dbConfig, String outputDir, Consumer<Double> progressCallback) throws Exception {
        List<TableMetadata> tables = databaseService.getTableMetadata(dbConfig);
        int totalTables = tables.size();
        int processedTables = 0;

        for (TableMetadata table : tables) {
            generateEntity(table, outputDir);
            processedTables++;
            progressCallback.accept((double) processedTables / totalTables);
        }
    }

    private void generateEntity(TableMetadata table, String outputDir) throws IOException {
        String className = config.getNameConverter().apply(table.getName());
        String fileName = className + ".java";
        File outputFile = new File(outputDir, fileName);

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("import javax.persistence.*;");
            writer.println("import lombok.*;");
            writer.println();
            writer.println("@Entity");
            writer.println("@Table(name = \"" + table.getName() + "\")");
            writer.println("@Data");
            writer.println("@NoArgsConstructor");
            writer.println("@AllArgsConstructor");
            if (config.isAddBuilderAnnotation()) {
                writer.println("@Builder");
            }
            writer.println("public class " + className + " {");

            for (ColumnMetadata column : table.getColumns()) {
                if (table.getPrimaryKeys().contains(column.getName())) {
                    writer.println("    @Id");
                    writer.println("    @GeneratedValue(strategy = GenerationType.IDENTITY)");
                }

                writer.println("    @Column(name = \"" + column.getName() + "\", nullable = " + column.isNullable() + ")");
                writer.println("    private " + mapJavaType(column.getDataType()) + " " + config.getNameConverter().apply(column.getName()) + ";");
                writer.println();
            }

            for (ForeignKeyMetadata fk : table.getForeignKeys()) {
                String referencedClassName = config.getNameConverter().apply(fk.getPkTableName());
                writer.println("    @ManyToOne");
                writer.println("    @JoinColumn(name = \"" + fk.getFkColumnName() + "\", referencedColumnName = \"" + fk.getPkColumnName() + "\")");
                writer.println("    private " + referencedClassName + " " + config.getNameConverter().apply(fk.getPkTableName()) + ";");
                writer.println();
            }

            // Generate OneToMany relationships
            for (TableMetadata otherTable : databaseService.getTableMetadata(config)) {
                for (ForeignKeyMetadata fk : otherTable.getForeignKeys()) {
                    if (fk.getPkTableName().equals(table.getName())) {
                        String otherClassName = config.getNameConverter().apply(otherTable.getName());
                        writer.println("    @OneToMany(mappedBy = \"" + config.getNameConverter().apply(table.getName()) + "\")");
                        writer.println("    private List<" + otherClassName + "> " + config.getNameConverter().apply(otherTable.getName()) + "List;");
                        writer.println();
                    }
                }
            }

            writer.println("}");
        } catch (Exception e) {
            logger.error("Error generating entity for table: " + table.getName(), e);
            throw new RuntimeException("Failed to generate entity for table: " + table.getName(), e);
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

    private String mapJavaType(String sqlType) {
        switch (sqlType.toUpperCase()) {
            case "VARCHAR":
            case "CHAR":
            case "TEXT":
                return "String";
            case "INT":
            case "INTEGER":
                return "Integer";
            case "BIGINT":
                return "Long";
            case "FLOAT":
                return "Float";
            case "DOUBLE":
                return "Double";
            case "BOOLEAN":
                return "Boolean";
            case "DATE":
                return "java.sql.Date";
            case "TIME":
                return "java.sql.Time";
            case "TIMESTAMP":
                return "java.sql.Timestamp";
            default:
                return "Object";
        }
    }
}

