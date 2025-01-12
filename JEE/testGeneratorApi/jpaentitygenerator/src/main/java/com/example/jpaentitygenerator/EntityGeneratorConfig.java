package com.example.jpaentitygenerator;

import java.util.function.Function;

public class EntityGeneratorConfig {
    private Function<String, String> nameConverter;
    private boolean addBuilderAnnotation;

    public EntityGeneratorConfig() {
        this.nameConverter = this::toPascalCase;
        this.addBuilderAnnotation = false;
    }

    public Function<String, String> getNameConverter() {
        return nameConverter;
    }

    public void setNameConverter(Function<String, String> nameConverter) {
        this.nameConverter = nameConverter;
    }

    public boolean isAddBuilderAnnotation() {
        return addBuilderAnnotation;
    }

    public void setAddBuilderAnnotation(boolean addBuilderAnnotation) {
        this.addBuilderAnnotation = addBuilderAnnotation;
    }

    private String toPascalCase(String input) {
        StringBuilder result = new StringBuilder();
        for (String word : input.split("_")) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }
        return result.toString();
    }
}

