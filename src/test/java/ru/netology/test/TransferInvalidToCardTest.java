package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.AmountDataGenerator;
import ru.netology.data.CardDataGenerator;
import ru.netology.data.InvalidFieldDataGenerator;
import ru.netology.data.TransferDataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferInvalidToCardTest extends BaseTransferTest{

    @Test
    public void shouldRejectTransferToFakeCard(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, CardDataGenerator.getFakeCardNumber(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferToShortCardNumber(){
        int initialFirstBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, CardDataGenerator.getShortCardNumber(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferToLongCardNumber(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, CardDataGenerator.getLongCardNumber(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsMissing(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, null, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsEmptyString(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getEmptyString(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsSpaces(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getSpaces(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsLatinLetters(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getLatinLetters(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsSpecialSymbols(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getSpecialSymbols(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsBoolean(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getBoolean(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsEmptyArray(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getEmptyArray(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsFilledArray(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getFilledArray(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsEmptyObject(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getEmptyObject(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenToIsFilledObject(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidTo(firstCard, InvalidFieldDataGenerator.getFilledObject(), amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }
}
