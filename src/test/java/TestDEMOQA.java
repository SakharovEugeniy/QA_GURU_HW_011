import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestDEMOQA extends TestBase {

    @Test
    @DisplayName("Проверка формы регистрации сайта demoqa")
    void demoqaFullFormTest() {

        step("Открываем домашнюю страницу demoqa с формой для заполнения", () -> {
            open("/automation-practice-form");
        });

        step("Заполняем все поля, чек боксы, радио кнопки и прикрепляем файл", () -> {
            $("[id=firstName]").setValue("Ivan");
            $("[id=lastName]").setValue("Ivanov");
            $("[id=userEmail]").setValue("IIvanov@gmail.com");
            $("[id=genterWrapper]").$(byText("Male")).click();
            $("[id=userNumber]").setValue("0123456789");
            $("[id=dateOfBirthInput]").click();
            $("[class=react-datepicker__month-select]").selectOption("January");
            $("[class=react-datepicker__year-select]").selectOption("2000");
            $("[class~=react-datepicker__day--001]").click();
            $("[id=subjectsInput]").setValue("Computer Science").sendKeys(Keys.TAB);
            $("[id=subjectsInput]").setValue("Commerce").sendKeys(Keys.TAB);
            $("[id=hobbiesWrapper]").$(byText("Sports")).click();
            $("[id=uploadPicture]").uploadFromClasspath("Screen Form.png");
            $("[id=currentAddress]").setValue("Some street 1");
            $("[id=state]").click();
            $("#stateCity-wrapper").$(byText("Rajasthan")).click();
            $("[id=city]").click();
            $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
            $("[id=submit]").click();
        });

        step("Проверяем на соответствие введёных данных и значений в готовой форме", () -> {
            $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
            $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text("IIvanov@gmail.com"));
            $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text("Male"));
            $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
            $("[class=table-responsive]").$(byText("Date of Birth")).parent().shouldHave(text("01 January,2000"));
            $("[class=table-responsive]").$(byText("Subjects")).parent().shouldHave(text("Computer Science, Commerce"));
            $("[class=table-responsive]").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
            $("[class=table-responsive]").$(byText("Picture")).parent().shouldHave(text("Screen Form.png"));
            $("[class=table-responsive]").$(byText("Address")).parent().shouldHave(text("Some street 1"));
            $("[class=table-responsive]").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaiselmer"));
        });
    }
}