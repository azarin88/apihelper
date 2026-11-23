package ru.netology.data;

import com.github.javafaker.Faker;
import ru.netology.model.InvalidTransferRequest;

import java.util.Locale;

public class CardDataGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

    private CardDataGenerator(){}

    public static InvalidTransferRequest getTransferRequestWithInvalidFrom(Object invalidFrom, String to, int amount) {
        return new InvalidTransferRequest(invalidFrom, to, amount);
    }

    public static InvalidTransferRequest getTransferRequestWithInvalidTo(String from, Object invalidTo, int amount) {
        return new InvalidTransferRequest(from, invalidTo, amount);
    }

    public static String getCardId() {
        return faker.internet().uuid();
    }

    public static String getFakeCardNumber() {
        return faker.numerify("#### #### #### ####");
    }

    public static String getShortCardNumber() {
        return faker.numerify("#### #### #### ###");
    }

    public static String getLongCardNumber() {
        return faker.numerify("#### #### #### #### #");
    }
}
