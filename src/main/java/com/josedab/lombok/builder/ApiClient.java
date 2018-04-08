package com.josedab.lombok.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@Builder
@Getter
public class ApiClient {
    @NonNull
    private String url;
    @NonNull
    private final String username;
    @NonNull
    private final String password;
    @Builder.Default
    private Boolean useHttps = true;
    private Map<String, String> configuration;
}
