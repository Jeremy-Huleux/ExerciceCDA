package com.example.jpaentitygenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ColumnMetadata {
    private String name;
    private String dataType;
    private boolean nullable;
}

