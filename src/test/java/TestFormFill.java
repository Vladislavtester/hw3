import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFormFill {
    @BeforeAll
static void beforeAll(){

    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com" ;   }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        $("#firstName").setValue("Vova");
        $("#lastName").setValue("Kashin");
        $("#userEmail").setValue("Kashin@mail.ru");
        $("#userEmail").setValue("Kashin@mail.ru");
        $("#submit").click();
}}
