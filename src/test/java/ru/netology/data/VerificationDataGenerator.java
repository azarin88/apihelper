package ru.netology.data;

import ru.netology.model.VerificationInformation;

public class VerificationDataGenerator {

    private VerificationDataGenerator(){}

    public static VerificationInformation getVerificationInformation (String login, String code) {
        return new VerificationInformation(login, code);
    }
}
