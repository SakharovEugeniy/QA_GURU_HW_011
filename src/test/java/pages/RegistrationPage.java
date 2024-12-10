package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput  = $("[id=firstName]"),
                            lastNameInput = $("[id=lastName]"),
                            emailInput = $("[id=userEmail]"),
                            genderWrapper = $("[id=genterWrapper]"),
                            userNumberInput = $("[id=userNumber]"),
                            calendarInput = $("[id=dateOfBirthInput]"),
                            subjectsInput = $("[id=subjectsInput]"),
                            hobbiesWrapper = $("[id=hobbiesWrapper]"),
                            uploadPictureInput = $("[id=uploadPicture]"),
                            addressInput = $("[id=currentAddress]").setValue("Some street 1"),
                            stateInput = $("[id=state]"),
                            cityInput = $("[id=city]"),
                            stateCityWrapper = $("#stateCity-wrapper"),
                            submitButton = $("[id=submit]");


    CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.setValue(value).sendKeys(Keys.TAB);
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage loadPicture(String fileName){
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage pressSubmit(){
        submitButton.click();
        return this;
    }


}

