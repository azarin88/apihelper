package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class InvalidFieldDataGenerator {

    private static final Faker faker = new Faker(new Locale("en"));

    private InvalidFieldDataGenerator(){}

    public static String getEmptyString() {
        return "";
    }

    public static String getSpaces() {
        return " ".repeat(faker.number().numberBetween(1, 10));
    }

    public static List<Object> getEmptyArray() {
        return List.of();
    }

    public static List<Object> getFilledArray() {
        return List.of(faker.lorem().word(), faker.lorem().word());
    }

    public static Map<String, Object> getEmptyObject() {
        return Map.of();
    }

    public static Map<String, Object> getFilledObject() {
        return Map.of(faker.lorem().word(), faker.lorem().word());
    }

    public static boolean getBoolean() {
        return faker.bool().bool();
    }

    public static String getLatinLetters() {
        return faker.letterify("??????");
    }

    public static String getSpecialSymbols() {
        return faker.regexify("[!@#%$_+=?]{6,10}");
    }
}
