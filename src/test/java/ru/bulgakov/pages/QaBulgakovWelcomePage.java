package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class QaBulgakovWelcomePage {
    private final SelenideElement costButton = $$(".t-menu__list li").last();
    public QaBulgakovWelcomePage clickCostButton() {
        costButton.click();

        return this;
    }
}
