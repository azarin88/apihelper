package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.handlers.ScalarHandler;



public class CardTransactionSQLClient extends BaseSQLClient{

    @SneakyThrows
    public int getTransactionsCount() {
        String sql = "SELECT COUNT(*) FROM card_transactions";
        try (var connection = getConnection()) {
            Long count = runner.query(connection, sql, new ScalarHandler<>());
            return count.intValue();
        }
    }

    @SneakyThrows
    public void clearTransactions() {
        String sql = "DELETE FROM card_transactions";
        try (var connection = getConnection()) {
            runner.update(connection, sql);
        }
    }
}
