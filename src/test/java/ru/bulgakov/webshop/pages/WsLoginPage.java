package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {
    private final SelenideElement loginTitle = $("div.page-title h1");
    private final SelenideElement loginEmailInput = $("input.email");
    private final SelenideElement loginPasswordInput = $("input.password");
    private final SelenideElement loginCheckboxRememberMe = $("input#RememberMe");
    private final SelenideElement loginSubmitButton = $("input.login-button");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");

    public WsLoginPage verifyLoginPageOpened() {
        loginTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    public WsLoginPage enterEmail(String email) {
        loginEmailInput.setValue(email);
        return this;
    }

    public WsLoginPage enterPassword(String password) {
        loginPasswordInput.setValue(password);
        return this;
    }

    public WsLoginPage rememberLoginAndPassword() {
        loginCheckboxRememberMe.click();
        return this;
    }

    public WsLoginPage submitLogin() {
        loginSubmitButton.click();
        return this;
    }

    public WsLoginPage checkUserLoggedIn(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }


}
