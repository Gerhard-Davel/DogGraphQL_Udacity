package com.udacity.bootstrap.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dogNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public dogNotFoundException(String message, Long id) {
        super(message);
        extensions.put("Invalid id", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

}
