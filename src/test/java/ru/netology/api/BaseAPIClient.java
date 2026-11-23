package ru.netology.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPIClient {

    protected final static String baseURL = "http://localhost";
    protected final static int port = 9999;

    protected final RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri(baseURL)
            .setPort(port)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .build();
}
