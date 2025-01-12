package com.example.jpaentitygenerator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
    private String databaseName;
    private String databaseType;

    public DatabaseConfig(String url, String username, String password, String databaseName, String databaseType) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.databaseName = databaseName;
        this.databaseType = databaseType;
    }
}

