package ru.netology.data;

import ru.netology.model.TransferRequest;

public class TransferDataGenerator {

    private TransferDataGenerator(){}

    public static TransferRequest getTransferRequest(String from, String to, int amount) {
        return new TransferRequest(from, to, amount);
    }

    public static String getBrokenJson() {
        return "{\"from\": \"broken\", \"amount\": ";
    }

    public static String getBrokenToken(String validToken) {
        return validToken + "a";
    }
}