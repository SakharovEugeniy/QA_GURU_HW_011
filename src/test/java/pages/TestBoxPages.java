package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxPages {

    private final SelenideElement nameInput = $("#userName"),
                                emailInput = $("#userEmail"),
                                currentAddressInput = $("#currentAddress"),
                                permanentAddressInput = $("#permanentAddress"),
                                submitButton =$("#submit"),
                                outputForm = $("#output");


    public TestBoxPages openPage(){
        open("/text-box");
        return this;
    }

    public TestBoxPages setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public TestBoxPages setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public TestBoxPages setPermanentAddress(String value){
        permanentAddressInput.setValue(value);
        return this;
    }
    public TestBoxPages setName(String value){
        nameInput.setValue(value);
        return this;
    }
    public TestBoxPages pressSubmit(){
        submitButton.click();
        return this;
    }
    public TestBoxPages checkOutputForm(String value){
        outputForm.shouldHave(text(value));
        return this;
    }
}
