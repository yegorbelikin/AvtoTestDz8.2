package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final QueryRunner QUERE_RUNNER = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getCon() throws SQLException {
        return DriverManager.getConnection(System.getProperty("db.url"), "YEGOR", "QWERT");
    }
    @SneakyThrows
    public static DataHelper.VerificationCode getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY create DESC LIMIT 1";
        try (var conn = getCon()) {
            return QUERE_RUNNER.query(conn, codeSQL, new BeanHandler<>(DataHelper.VerificationCode.class));
        }
    }

    @SneakyThrows
    public static void cleanDatabase() {
        try (var conn = getCon()) {
            QUERE_RUNNER.execute(conn, "DELETE FROM auth_codes");
            QUERE_RUNNER.execute(conn, "DELETE FROM cards");
            QUERE_RUNNER.execute(conn, "DELETE FROM card_transactions");
            QUERE_RUNNER.execute(conn, "DELETE FROM users");
        }
    }

    @SneakyThrows
    public static void cleanAuthCodes() {
        try (var conn = getCon()) {
            QUERE_RUNNER.execute(conn, "DELETE FROM auth_codes");
        }
    }

}
