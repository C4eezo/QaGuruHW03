import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class practiceformtests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Mihal");
        $("#lastName").setValue("Palich");
        $("#userEmail").setValue("mihal@terentev.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("89994304300");
        $("#dateOfBirthInput").setValue("15 Feb 1990");
        $("#subjectsInput").val("Maths").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("img/cat.png");
        $("#currentAddress").setValue("Some street 1");
        $("#submit").scrollIntoView(false); // Пришлось добавить т.к. на экране ноутбука без монитора не влезает :)
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Gurgaon")).click();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Mihal Palich "));
        $(".table-responsive").shouldHave(text("mihal@terentev.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("89994304300"));
        $(".table-responsive").shouldHave(text("15 February,1990"));
        $(".table-responsive").shouldHave(text("Math"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("cat.png"));
        $(".table-responsive").shouldHave(text("Some street 1"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));
    }
}