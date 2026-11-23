package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class AuthenticationCodeSQLClient extends BaseSQLClient{

    @SneakyThrows
    public String getLastCode(String userId) {
        String sql = "SELECT code FROM auth_codes WHERE user_id = ? ORDER BY created DESC LIMIT 1";
        try (var connection = getConnection()) {
            return runner.query(connection, sql, new ScalarHandler<>(), userId);
        }
    }

    @SneakyThrows
    public void clearAuthenticationCodes() {
        String sql = "DELETE FROM auth_codes";
        try (var connection = getConnection()) {
            runner.update(connection, sql);
        }
    }

}
