import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFormFill {
    @BeforeAll
static void beforeAll(){

    Configuration.browserSize = "1080x1080";
    Configuration.baseUrl = "https://demoqa.com" ;
    Configuration.holdBrowserOpen=true ;
    }

    @Test
    void fillFormTest()  {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Vova");
        $("#lastName").setValue("Kashin");
        $("#userEmail").setValue("Kashin@mail.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").val("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2007");
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("bio").pressEnter();
        $("#hobbiesWrapper").$(byText ("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Pushkina 12");
        $("#state").click();
        $("#stateCity-wrapper").$(byText ("Haryana")).click();
        $("#city").click();
        $("#city").$(byText ("Panipat")).click();
        $("#submit").click();

        //Проверки
        $(".modal-body").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Kashin@mail.ru"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("Pushkina 12"));

}}
