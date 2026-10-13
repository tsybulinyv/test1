package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
//        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

        open("https://ivanbulgakovqa.ru/");
        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div/span").click();
        $(byText("Бегу оплачивать")).click();
        switchTo().window(1);
        $("h3[data-at='H3'][class*='price']").shouldHave(text("47 000.00"));
    }

    @Test
    void demoQaPracticeFormTest() {
//                Configuration.holdBrowserOpen = true;
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Yaroslav");
        $("#lastName").setValue("Tsybulin");
        $("#userEmail").setValue("example@gmail.com");
        $("input[name='gender'][value='Male']").click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths");
        $(".subjects-auto-complete__option").shouldHave(text("Maths")).click();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("Y:/1.png"));
        $("#currentAddress").setValue("Ulitsa Pushkina, Dom Kolotushkina");
        $("#react-select-3-input").scrollIntoView(true).click();
        $("#react-select-3-option-2").scrollIntoView(true).click();
        $("#react-select-4-input").scrollIntoView(true).click();
        $("#react-select-4-option-1").scrollIntoView(true).click();
        $("#submit").scrollIntoView(true).click();
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".modal-content tbody tr").findBy(text("Student Name")).shouldHave(text("Yaroslav Tsybulin"));
        $$(".modal-content tbody tr").findBy(text("Student Email")).shouldHave(text("example@gmail.com"));
        $$(".modal-content tbody tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$(".modal-content tbody tr").findBy(text("Mobile")).shouldHave(text("8005553535"));
        $$(".modal-content tbody tr").findBy(text("Subjects")).shouldHave(text("Maths"));
        $$(".modal-content tbody tr").findBy(text("Address")).shouldHave(text("Ulitsa Pushkina, Dom Kolotushkina"));

    }
}