package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class VerificationPage {
    private final SelenideElement codeInputField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton =  $("[data-test-id=action-verify]");
    private final SelenideElement errorField = $("[data-test-id='error-notification'] .notification__content");


    public VerificationPage() {
        codeInputField.shouldBe(Condition.visible);
    }

    public DashBoardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashBoardPage();
    }
    public void verify(String verificationCode) {
        codeInputField.setValue(verificationCode);
        verifyButton.click();
    }
    public void errorNotification(String expectedText) {
        errorField.shouldBe(exactText(expectedText)).shouldBe(Condition.visible);
    }
}
