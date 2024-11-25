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

            //complete the form

            $("[id=firstName]").setValue("Ivan");

            $("[id=lastName]").setValue("Ivanov");

            $("[id=userEmail]").setValue("IIvanov@gmail.com");

            $(byText("Male")).click();

            $("[id=userNumber]").setValue("0123456789");

            $("[id=dateOfBirthInput]").click();
            $("[class=react-datepicker__month-select]").selectOption("January");
            $("[class=react-datepicker__year-select]").selectOption("2000");
            $("[class~=react-datepicker__day--001]").click();

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

            $("[id=submit]").click();


            //complete the form

            $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));

            //                                            НАПОМИНАЛКА
            //$("[class=table-responsive]").$(byText("Student Name")).sibling(0).shouldHave(text("Ivan Ivanov"));
            // Можно искать не в родительском эл-те а в родственном , sibling(0) первый родственный после найденного

            $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text("IIvanov@gmail.com"));
            $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text("Male"));
            $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
            $("[class=table-responsive]").$(byText("Date of Birth")).parent().shouldHave(text("01 January,2000"));
            $("[class=table-responsive]").$(byText("Subjects")).parent().shouldHave(text("Computer Science, Commerce"));
            $("[class=table-responsive]").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
            $("[class=table-responsive]").$(byText("Picture")).parent().shouldHave(text("Screen Form.png"));
            $("[class=table-responsive]").$(byText("Address")).parent().shouldHave(text("Some street 1"));
            $("[class=table-responsive]").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaiselmer"));
    }
}