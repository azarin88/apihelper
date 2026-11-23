package ru.netology.sql;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseSQLClient {

    private static final String baseURL = "jdbc:mysql://localhost:3306/app";
    private static final String user = "app";
    private static final String password = "pass";

    protected final QueryRunner runner = new QueryRunner();

    @SneakyThrows
    protected Connection getConnection() {
        return DriverManager.getConnection(baseURL, user, password);
    }
}
