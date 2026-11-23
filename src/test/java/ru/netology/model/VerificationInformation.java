package ru.netology.model;

import lombok.Value;

@Value
public class VerificationInformation {
    String login;
    String code;
}