package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.AmountDataGenerator;
import ru.netology.data.InvalidFieldDataGenerator;
import ru.netology.data.TransferDataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferInvalidAmountTest extends BaseTransferTest{

    @Test
    public void shouldRejectTransferWhenAmountExceedsBalance(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getAmountMoreThanBalance(initialBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithZeroAmount(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getZeroAmount();

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWithNegativeAmount(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getNegativeAmount();

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsMissing(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, null);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsNumberAsString(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = AmountDataGenerator.getNumberAsString();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsEmptyString(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getEmptyString();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsSpaces(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getSpaces();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsLatinLetters(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getLatinLetters();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsSpecialSymbols(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getSpecialSymbols();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsBoolean(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getBoolean();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsEmptyArray(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getEmptyArray();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsFilledArray(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getFilledArray();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsEmptyObject(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getEmptyObject();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenAmountIsFilledObject(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        var amount = InvalidFieldDataGenerator.getFilledObject();

        var request = AmountDataGenerator.getTransferRequestWithInvalidAmount(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }
}
