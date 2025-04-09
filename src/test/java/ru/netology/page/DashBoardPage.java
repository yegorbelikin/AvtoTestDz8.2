package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage {
    private final SelenideElement pageTitle = $("[data-test-id=dashboard]");

    public DashBoardPage() {
        pageTitle.shouldHave(text("Личный кабинет")).shouldBe(Condition.visible);
    }
}
