package com.example.jpaentitygenerator;

import lombok.Data;
import java.util.*;

@Data
public class TableMetadata {
    private String name;
    private List<ColumnMetadata> columns = new ArrayList<>();
    private List<String> primaryKeys = new ArrayList<>();
    private List<ForeignKeyMetadata> foreignKeys = new ArrayList<>();

    public TableMetadata(String name) {
        this.name = name;
    }

    public void addColumn(ColumnMetadata column) {
        columns.add(column);
    }

    public void addPrimaryKey(String columnName) {
        primaryKeys.add(columnName);
    }

    public void addForeignKey(ForeignKeyMetadata foreignKey) {
        foreignKeys.add(foreignKey);
    }
}

