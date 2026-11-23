package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferPositiveTest extends BaseTransferTest {

    @Test
    public void shouldTransferValidAmount() {
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialFirstBalance);

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(200);

        assertEquals(initialFirstBalance - amount, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance + amount, cardSql.getCardBalance(secondCard));
        assertEquals(1, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldTransferMinValidAmount(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getMinValidAmount();

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(200);

        assertEquals(initialFirstBalance - amount, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance + amount, cardSql.getCardBalance(secondCard));
        assertEquals(1, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldTransferFullBalance(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = cardSql.getCardBalance(firstCard);

        var request = TransferDataGenerator.getTransferRequest(firstCard, secondCard, amount);

        transferClient.transfer(token, request)
                .statusCode(200);

        assertEquals(initialFirstBalance - amount, cardSql.getCardBalance(firstCard));
        assertEquals(initialSecondBalance + amount, cardSql.getCardBalance(secondCard));
        assertEquals(1, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldTransferInReverseDirection(){
        int initialFirstBalance = cardSql.getCardBalance(firstCard);
        int initialSecondBalance = cardSql.getCardBalance(secondCard);
        int amount = AmountDataGenerator.getValidAmount(initialSecondBalance);

        var request = TransferDataGenerator.getTransferRequest(secondCard, firstCard, amount);

        transferClient.transfer(token, request)
                .statusCode(200);

        assertEquals(initialSecondBalance - amount, cardSql.getCardBalance(secondCard));
        assertEquals(initialFirstBalance + amount, cardSql.getCardBalance(firstCard));
        assertEquals(1, transactionSql.getTransactionsCount());
    }

    @Test
    public void shouldTransferToPetyaCard(){}
}
