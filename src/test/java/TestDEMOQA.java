import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDEMOQA {
    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void testDemoqaFullForm() {
            open("https://demoqa.com/automation-practice-form");

            $("[id=firstName]").setValue("Ivan");

            $("[id=lastName]").setValue("Ivanov");

            $("[id=userEmail]").setValue("IIvanov@gmail.com");

            $(byText("Male")).click();

            $("[id=userNumber]").setValue("0123456789");



            //$("[id=dateOfBirthInput]").click();
            //$("[id=dateOfBirthInput]").setValue("21 Nov 2024");

            $("[id=subjectsInput]").setValue("Computer Science").sendKeys(Keys.TAB);
            $("[id=subjectsInput]").setValue("Commerce").sendKeys(Keys.TAB);
            $(byText("Sports")).click();

            File fileToUpload = new File("src/test/resources/Screen Form.png");
            $("[id=uploadPicture]").uploadFile(fileToUpload);

            $("[id=currentAddress]").setValue("Some street 1");

            $("[id=state]").click();
            $(byText("Rajasthan")).click();
            $("[id=city]").click();
            $(byText("Jaiselmer")).click();

      /*      $("[id=dateOfBirthInput]").click();
            $("[class=react-datepicker__month-select]").selectOption("January");
            $("[class=react-datepicker__year-select]").selectOption("2000");
            $("[class=react-datepicker__day--001]").click();*/

            $("[id=submit]").click();





    }
}