import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.Find;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFormFill {
    @BeforeAll
static void beforeAll(){

    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com" ;   }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");

        $("#firstName").setValue("Vova");
        $("#lastName").setValue("Kashin");
        $("#userEmail").setValue("Kashin@mail.ru");
        $("#gender-radio-1").sendKeys(" ");
        $("#userNumber").val("12345");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--015").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2007");
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").sendKeys(" 1254");
        //$(".subjects-auto-complete__input").setValue("Swimming");
        //$(".subjects-auto-complete__input").sendKeys(" Swimming");




//подправить конечные проверки
       // $("#output").shouldHave(text("Vova Bobin"), text("Vova@mail.ru"),
         //       text("Omsk 19"), text("Another adress"));
}}
