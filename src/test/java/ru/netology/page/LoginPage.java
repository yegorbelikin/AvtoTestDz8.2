package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public final SelenideElement loginField = $("[data-test-id= 'login'] input");
    public final SelenideElement passwordField = $("[data-test-id= 'password'] input");
    public final SelenideElement loginButton = $("[data-test-id= 'action-login']");
    public final SelenideElement errorField = $("[data-test-id= 'error-notification'] .notification__content");


    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void login(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }



    public void errorNotification(String expectedText) {
        errorField.shouldHave(exactText(expectedText)). shouldBe(Condition.visible);
    }
}