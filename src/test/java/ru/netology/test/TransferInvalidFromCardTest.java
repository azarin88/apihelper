package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.AmountDataGenerator;
import ru.netology.data.CardDataGenerator;
import ru.netology.data.InvalidFieldDataGenerator;
import ru.netology.data.TransferDataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferInvalidFromCardTest extends BaseTransferTest{

    @Test
    public void shouldRejectTransferToSameCard(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, firstCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialFirstBalance, cardSql.getCardBalance(firstCard));
        assertEquals(1, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferFromFakeCard(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = TransferDataGenerator.getTransferRequest(CardDataGenerator.getFakeCardNumber(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferFromShortCardNumber(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = TransferDataGenerator.getTransferRequest(CardDataGenerator.getShortCardNumber(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferFromLongCardNumber(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = TransferDataGenerator.getTransferRequest(CardDataGenerator.getLongCardNumber(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsMissing(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(null, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsEmptyString(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getEmptyString(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsSpaces(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getSpaces(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsLatinLetters(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getLatinLetters(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsSpecialSymbols(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getSpecialSymbols(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsBoolean(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getBoolean(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsEmptyArray(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getEmptyArray(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsFilledArray(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getFilledArray(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsEmptyObject(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getEmptyObject(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldRejectTransferWhenFromIsFilledObject(){
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = CardDataGenerator.getTransferRequestWithInvalidFrom(InvalidFieldDataGenerator.getFilledObject(), secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(400);

        assertEquals(initialSecondBalance, cardSql.getCardBalance(secondCard));
        assertEquals(0, transactionSql.getTransactionsCount());
    }
}
