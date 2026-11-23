package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class CardSQLClient extends BaseSQLClient {

    @SneakyThrows
    public List<String> getUserCards(String userId) {
        String sql = "SELECT number FROM cards WHERE user_id = ? ORDER BY number ASC";
        try (var connection = getConnection()) {
            return runner.query(connection, sql, new ColumnListHandler<>(), userId);
        }
    }

    @SneakyThrows
    public int getCardBalance(String cardNumber) {
        String sql = "SELECT balance_in_kopecks FROM cards WHERE number = ?";
        try (var connection = getConnection()) {
            Integer balanceInKopecks = runner.query(connection, sql, new ScalarHandler<>(), cardNumber);
            return balanceInKopecks / 100;
        }
    }

    @SneakyThrows
    public void resetAllBalances(int balanceInRubles) {
        String sql = "UPDATE cards SET balance_in_kopecks = ?";
        try (var connection = getConnection()) {
            runner.update(connection, sql, balanceInRubles * 100);
        }
    }

    @SneakyThrows
    public void addCard(String cardId, String userId, String cardNumber, int balanceInRubles) {
        String sql = "INSERT INTO cards (id, user_id, number, balance_in_kopecks) VALUES (?, ?, ?, ?)";
        try (var connection = getConnection()) {
            runner.update(connection, sql, cardId, userId, cardNumber, balanceInRubles * 100);
        }
    }

    @SneakyThrows
    public void deleteCard(String cardNumber) {
        String sql = "DELETE FROM cards WHERE number = ?";
        try (var connection = getConnection()) {
            runner.update(connection, sql, cardNumber);
        }
    }
}