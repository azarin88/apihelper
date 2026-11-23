package ru.netology.model;

import lombok.Value;

@Value
public class AuthenticationInformation {
    String login;
    String password;
}