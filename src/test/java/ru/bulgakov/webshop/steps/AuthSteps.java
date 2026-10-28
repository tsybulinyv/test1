package ru.bulgakov.webshop.steps;

import ru.bulgakov.webshop.pages.WsRegistrationPage;
import net.datafaker.Faker;

import static com.codeborne.selenide.Selenide.open;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;

public class AuthSteps {

    private static final Faker faker = new Faker();
    String email = faker.internet().emailAddress();

    public void registerNewUser() {


        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        faker.harryPotter().character()+faker.number().positive())
                .checkUserLoggedIn(email);
    }
}
