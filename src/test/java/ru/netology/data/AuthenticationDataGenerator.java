package ru.netology.data;

import ru.netology.model.AuthenticationInformation;

public class AuthenticationDataGenerator {

    private AuthenticationDataGenerator(){}

    public static AuthenticationInformation getFirstAuthenticationInformation() {
        return new AuthenticationInformation("vasya", "qwerty123");
    }

    public static AuthenticationInformation getSecondAuthenticationInformation() {
        return new AuthenticationInformation("petya", "123qwerty");
    }
}
