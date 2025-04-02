package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Locale;

public class DataHelper {
    private DataHelper(){

    }

    private static final Faker faker = new Faker(new Locale("en"));

    public static AuthInfo getAuthInfo() {
        return new AuthInfo ("vasya", "qwerty123");
    }
    private static String randomLogin() {
        return faker.name().username();
    }
    private static String randomPassword() {
        return faker.internet().password();
        }
    public static AuthInfo randomAuthInfo() {
        return new AuthInfo(randomLogin(), randomPassword());
    }

    public static VerificationCode randomCode() {
        return new VerificationCode(faker.numerify("#####"));

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VerificationCode {
        String code;
    }



    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}
