package ru.netology.api;

import ru.netology.model.AuthenticationInformation;
import ru.netology.model.VerificationInformation;

import static io.restassured.RestAssured.given;

public class AuthenticationAPIClient extends BaseAPIClient{

    private static final String authenticationEndpoint = "/api/auth";
    private static final String verificationEndpoint = "/api/auth/verification";

    public void login (AuthenticationInformation information){
        given()
                .spec(specification)
                .body(information)
                .when()
                .post(authenticationEndpoint)
                .then()
                .statusCode(200);
    }

    public String verification(VerificationInformation information){
        return given()
                .spec(specification)
                .body(information)
                .when()
                .post(verificationEndpoint)
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}