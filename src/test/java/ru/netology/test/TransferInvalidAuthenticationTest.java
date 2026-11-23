package ru.netology.test;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import ru.netology.data.AmountDataGenerator;
import ru.netology.data.TransferDataGenerator;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferInvalidAuthenticationTest extends BaseTransferTest{

    @Test
    public void shouldRejectTransferWithoutAuthenticationHeader(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);
        var headers = Map.of("Content-Type", "application/json");

        transferClient.transferWithAnotherHeaders(headers, jsonBody)
                .statusCode(401);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithEmptyToken(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);
        var headers = Map.of("Authorization", "Bearer ","Content-Type", "application/json");

        transferClient.transferWithAnotherHeaders(headers, jsonBody)
                .statusCode(401);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithInvalidToken(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);
        var brokenToken = TransferDataGenerator.getBrokenToken(token);
        var headers = Map.of("Authorization", "Bearer " + brokenToken,"Content-Type", "application/json");

        transferClient.transferWithAnotherHeaders(headers, jsonBody)
                .statusCode(401);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithoutBearerPrefix(){        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);
        var headers = Map.of("Authorization", token,"Content-Type", "application/json");

        transferClient.transferWithAnotherHeaders(headers, jsonBody)
                .statusCode(401);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());}

    @Test
    public void shouldRejectTransferFromAnotherUsersCard(){}
}