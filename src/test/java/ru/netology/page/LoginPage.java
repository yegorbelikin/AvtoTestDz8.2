package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public final SelenideElement loginField = $("[data-test-id= 'login'] input");
    public final SelenideElement passwordField = $("[data-test-id= 'password'] input");
    public final SelenideElement loginButton = $("[data-test-id= ]");
    public final SelenideElement errorField = $("[data-test-id= ");


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void login(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        log

    public void errorNotification(String expectedText) {
        errorField.shouldHave(Condition.exactText(expectedText)). shouldBe(Condition.visible);
    }
}