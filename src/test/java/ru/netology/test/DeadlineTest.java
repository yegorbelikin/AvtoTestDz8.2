package ru.netology.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;

import static java.nio.channels.FileChannel.open;
import static ru.netology.data.SQLHelper.cleanAuthCodes;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class DeadlineTest {
    LoginPage loginPage;
    DataHelper.AuthInfo authInfo = DataHelper.getAuthInfo();

    @AfterAll
    static void tearDownAll() {
        cleanDatabase();
    }

    @AfterEach
    void tearDown() {
        cleanAuthCodes();
    }

    @BeforeEach
    void setUp() {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
    }

    @Test
    void successfulLogin() {
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    void errorLogin() {
        var authInfo = DataHelper.randomAuthInfo();
        loginPage.login(authInfo);
        loginPage.errorNotification("Ошибка! \nНеверно указан логин или пароль");
    }

    @Test
    void errorCode() {
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.randomCode();
        verificationPage.verify(verificationCode.getCode());
        verificationPage.errorNotification("Ошибка! \nНеверно указан код! Попробуйте ещё раз.");
    }


}
