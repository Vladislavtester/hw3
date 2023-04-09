package tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFormFill extends TestBase {

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender("Other")
                .setNumber()
                .setBirthDate("15","July","2008");

        $("#subjectsInput").setValue("bio").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Pushkina 12");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();

        //Проверки

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", "Vova Kashin")
                .verifyResult("Student Email", "Kashin@mail.ru")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Address", "Pushkina 12");


    }
}
