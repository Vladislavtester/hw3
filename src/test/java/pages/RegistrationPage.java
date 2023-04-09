package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationResultsModal;
import pages.components.calendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    calendarComponent calendarComponent =new calendarComponent();
    RegistrationResultsModal registrationResultsModal= new RegistrationResultsModal();
    private SelenideElement lastNameInput= $("#lastName"),
    firstNameInput= $("#firstName"),
            emailInput= $("#userEmail"),
    numberInput = $("#userNumber");
    private final String TITLE_TEXT="Student Registration Form";
    public RegistrationPage openPage()
    {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName() {
        firstNameInput.setValue("Vova");

        return this;
    }
    public RegistrationPage setLastName() {
        lastNameInput.setValue("Kashin");

        return this;
    }
    public RegistrationPage setEmail() {
        emailInput.setValue("Kashin@mail.ru");

        return this;
    }
    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText (value)).click();

        return this;
    }
    public RegistrationPage setNumber() {
        numberInput.setValue("1234567890");

        return this;

    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate( day, month, year);

        return this;
    }

        public RegistrationPage verifyModalAppears() {

        registrationResultsModal.verifyResultsModalAppears();

        return this;

    }
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key,value);
        return this;
    }
}

