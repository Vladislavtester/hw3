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
                .setBirthDate("15","July","2008")
                .setSubject("bio")
                .setHobbie("Reading")
                .addPhoto()
                .setAddres()
                .setState("Haryana")
                .setCity("Panipat")
                .submitConfirm();

        //Проверки

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", "Vova Kashin")
                .verifyResult("Student Email", "Kashin@mail.ru")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Address", "Pushkina 12");


    }
}
