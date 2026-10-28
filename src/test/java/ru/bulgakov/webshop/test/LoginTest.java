package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsRegistrationPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class LoginTest {

        private static final Faker faker = new Faker();
        String email;
        String password;

        @BeforeEach
        void beforeEach() {
            password = (faker.harryPotter().character()+faker.number().positive());
            email = faker.internet().emailAddress();

            open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                    .register(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            email,
                            password)
            .checkUserLoggedIn(email);

            cookies().clear();
            localStorage().clear();
            sessionStorage().clear();
        }

        @Test
        void successLoginTest() {

            open(WEB_SHOP_URL, WsWelcomePage.class)
                    .openLoginPage()
                    .verifyLoginPageOpened()
                    .enterEmail(email)
                    .enterPassword(password)
                    .rememberLoginAndPassword()
                    .submitLogin()
                    .checkUserLoggedIn(email);

            System.out.println(1);





        }
}
