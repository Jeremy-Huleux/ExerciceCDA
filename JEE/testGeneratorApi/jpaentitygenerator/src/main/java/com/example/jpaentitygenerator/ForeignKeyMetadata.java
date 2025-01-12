package com.example.jpaentitygenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForeignKeyMetadata {
    private String fkColumnName;
    private String pkTableName;
    private String pkColumnName;
}

