package ru.netology.test;

import com.google.gson.Gson;
import io.restassured.http.Method;
import org.junit.jupiter.api.Test;
import ru.netology.data.AmountDataGenerator;
import ru.netology.data.InvalidFieldDataGenerator;
import ru.netology.data.TransferDataGenerator;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferInvalidRequestTest extends BaseTransferTest{

    @Test
    public void shouldRejectTransferWithEmptyBody(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        String brokenJson = InvalidFieldDataGenerator.getEmptyString();

        transferClient.transfer(token, brokenJson)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithBrokenJson(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        String brokenJson = TransferDataGenerator.getBrokenJson();

        transferClient.transfer(token, brokenJson)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithWrongContentType(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);
        var headers = Map.of("Authorization", "Bearer " + token, "Content-Type", "text/plain");

        transferClient.transferWithAnotherHeaders(headers, jsonBody)
                .statusCode(415);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithGetMethod(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);

        transferClient.transferWithAnotherMethod(Method.GET, token, "")
                .statusCode(405);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithPutMethod(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);

        transferClient.transferWithAnotherMethod(Method.PUT, token, jsonBody)
                .statusCode(405);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithDeleteMethod(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);

        transferClient.transferWithAnotherMethod(Method.DELETE, token, jsonBody)
                .statusCode(405);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithWrongUrl(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialBalance);
        var body = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);
        String jsonBody = new Gson().toJson(body);

        transferClient.transferToAnotherPath("/api/transfers", token, jsonBody)
                .statusCode(404);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }
}
