package ru.bulgakov.webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    private static final Faker faker = new Faker();

    @Test
    void registrationTest() {
        String password = (faker.harryPotter().character()+faker.number().positive());
        String email = faker.internet().emailAddress();

        open("https://demowebshop.tricentis.com/", WsWelcomePage.class)
                .openRegistration()
                .verifyRegistrationOpened()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkUserLoggedIn(email);

        System.out.println(1);
    }
}
