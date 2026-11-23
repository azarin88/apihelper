package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserSQLClient extends BaseSQLClient{

    @SneakyThrows
    public String getUserId(String login) {
        String sql = "SELECT id FROM users WHERE login = ?";
        try (var connection = getConnection()) {
            return runner.query(connection, sql, new ScalarHandler<>(), login);
        }
    }
}
