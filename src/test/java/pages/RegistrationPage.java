package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            emailInput = $("[id=userEmail]"),
            genderWrapper = $("[id=genterWrapper]"),
            userNumberInput = $("[id=userNumber]"),
            calendarInput = $("[id=dateOfBirthInput]"),
            subjectsInput = $("[id=subjectsInput]"),
            hobbiesWrapper = $("[id=hobbiesWrapper]"),
            uploadPictureInput = $("[id=uploadPicture]"),
            addressInput = $("[id=currentAddress]"),
            stateInput = $("[id=state]"),
            cityInput = $("[id=city]"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("[id=submit]"),
            tableResponse = $("[class=table-responsive]"),
            userForm = $("#userForm");


    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Input First Name {0}")
    public RegistrationPage setName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Input Last Name {0}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Input Email {0}")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Choose Gender {0}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Input Mobile Number {0}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Choose Date of Birth {0}.{1}.{2}")
    public RegistrationPage setDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Input Subjects  {0}")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).sendKeys(Keys.TAB);
        return this;
    }

    @Step("Choose Hobbies  {0}")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Load File")
    public RegistrationPage loadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Input Current Address {0}")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Select State {0}")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Select City  {0} ")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Press Submit")
    public RegistrationPage pressSubmit() {
        submitButton.scrollTo().click();
        return this;
    }

    @Step("Проверяем, что поле {0} соответствует значению {1} введённому нами")
    public RegistrationPage checkResponseField(String value1, String value2) {
        tableResponse.$(byText(value1)).parent().shouldHave(text(value2));
        return this;
    }

    @Step("Should not be validated")
    public void wasValidate() {
        userForm.shouldHave(cssClass("was-validated"));
    }
}

