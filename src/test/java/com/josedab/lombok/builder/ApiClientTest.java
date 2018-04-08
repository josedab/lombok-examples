package com.josedab.lombok.builder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;


import org.junit.Test;

public class ApiClientTest {

    private static final String URL = "https://myapi.mydomain.com";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "y0u_sh4ll_n0t_p4$$";

    @Test(expected = NullPointerException.class)
    public void testApiClientWithNoRequiredThrowsException() {
        ApiClient.builder()
                .url(URL)
                .username(USERNAME)
                .build();
    }

    @Test
    public void testApiClientWithRequiredArgumentsBuilds() {
        final ApiClient apiClient = ApiClient.builder()
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();

        assertThat(apiClient.getUrl(), is(URL));
        assertThat(apiClient.getUsername(), is(USERNAME));
        assertThat(apiClient.getPassword(), is(PASSWORD));
        assertThat(apiClient.getConfiguration(), is(nullValue()));
        assertThat(apiClient.getUseHttps(), is(true));
    }

    @Test
    public void testApiClientDefaultArgumentValue() {
        final ApiClient apiClient = ApiClient.builder()
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();

        assertThat(apiClient.getUseHttps(), is(true));
    }

    @Test
    public void testApiClientDefaultBuilderArgumentSpecified() {
        final ApiClient apiClient = ApiClient.builder()
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .useHttps(false)
                .build();

        assertThat(apiClient.getUseHttps(), is(false));
    }
}
