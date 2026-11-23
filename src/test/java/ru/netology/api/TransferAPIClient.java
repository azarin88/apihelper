package ru.netology.api;

import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;


import java.util.Map;

import static io.restassured.RestAssured.given;

public class TransferAPIClient extends BaseAPIClient{

    private static final String transferEndpoint = "/api/transfer";

    public ValidatableResponse transfer(String token, Object body){
        return given()
                .spec(specification)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post(transferEndpoint)
                .then();
    }

    public ValidatableResponse transferWithAnotherMethod(Method method, String token, Object body){
        return given()
                .spec(specification)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .request(method, transferEndpoint)
                .then();
    }

    public ValidatableResponse transferToAnotherPath(String path,String token, Object body){
        return given()
                .spec(specification)
                .header("Authorization", "Bearer " + token)
                .body(body)
                .when()
                .post(path)
                .then();
    }

    public ValidatableResponse transferWithAnotherHeaders(Map<String, String> headers, Object body){
        return given()
                .baseUri(baseURL)
                .port(port)
                .headers(headers)
                .body(body)
                .when()
                .post(transferEndpoint)
                .then();
    }
}