package ru.netology.data;

import com.github.javafaker.Faker;
import ru.netology.model.InvalidTransferRequest;

import java.util.Locale;

public class AmountDataGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

    private AmountDataGenerator(){}

    public static InvalidTransferRequest getTransferRequestWithInvalidAmount(String from, String to, Object invalidAmount) {
        return new InvalidTransferRequest(from, to, invalidAmount);
    }

    public static int getValidAmount(int balance) {
        return faker.number().numberBetween(1, balance + 1);
    }

    public static int getMinValidAmount() {
        return 1;
    }

    public static int getAmountMoreThanBalance(int balance) {
        return balance + 1;
    }

    public static int getZeroAmount() {
        return 0;
    }

    public static int getNegativeAmount() {
        return -faker.number().numberBetween(1, 10000);
    }

    public static String getNumberAsString() {
        return String.valueOf(faker.number().numberBetween(1, 10000));
    }
}
