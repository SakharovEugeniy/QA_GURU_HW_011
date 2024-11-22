import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
            $("[id=userNumber]").setValue("+123456789");



    }
}
