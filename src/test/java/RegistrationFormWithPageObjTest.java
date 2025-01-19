import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    GenerationData generationData = new GenerationData();

    @Test
    @Step("Проверка заполнения всех доступных полей формы регистрации сайта demoqa")
    public void registrationFullFormWithPageObjTest() {

        registrationPage.openPage()
                .setName(generationData.generationName())
                .setLastName(generationData.generationLastName())
                .setEmail(generationData.generationEmail())
                .setGender(generationData.generationGender())
                .setUserNumber(generationData.generationPhoneNumber())
                .setDate(generationData.generationDayBirth(), generationData.generationMonthBirth(), generationData.generationYearBirth())
                .setSubjects(generationData.generationSubject())
                .setHobbies(generationData.generationHobbies())
                .loadPicture(generationData.generationFile())
                .setAddress(generationData.generationAddress())
                .setState(generationData.generationState())
                .setCity(generationData.generationCity())
                .pressSubmit()
                .checkResponseField("Student Name", generationData.getName())
                .checkResponseField("Student Email", generationData.getEmail())
                .checkResponseField("Gender", generationData.getGender())
                .checkResponseField("Mobile", generationData.getPhoneNumber())
                .checkResponseField("Date of Birth", generationData.getDayBirth() + " " + generationData.getMonthBirth()
                        + "," + generationData.getYearBirth())
                .checkResponseField("Subjects", generationData.getSubject())
                .checkResponseField("Hobbies", generationData.getHobbies())
                .checkResponseField("Picture", generationData.getFileName())
                .checkResponseField("Address", generationData.getAddress())
                .checkResponseField("State and City", generationData.getState() + " " + generationData.getCity());
    }


    @Test
    @Step("Проверка заполнения минимального количества полей формы регистрации сайта demoqa")
    public void registrationMinimalFormWithPageObjTest() {

        registrationPage.openPage()
                .setName(generationData.generationName())
                .setLastName(generationData.generationLastName())
                .setGender(generationData.generationGender())
                .setUserNumber(generationData.generationPhoneNumber())
                .setDate(generationData.generationDayBirth(), generationData.generationMonthBirth(), generationData.generationYearBirth())
                .pressSubmit()
                .checkResponseField("Student Name", generationData.getName() + " " + generationData.getLastName())
                .checkResponseField("Gender", generationData.getGender())
                .checkResponseField("Mobile", generationData.getPhoneNumber())
                .checkResponseField("Date of Birth", generationData.getDayBirth() + " " + generationData.getMonthBirth()
                        + "," + generationData.getYearBirth());
    }


    @Test
    @Step("Проверка невозможности регистрации с пустыми полями")
    public void registrationEmptyFormWithPageObjTest() {

        registrationPage.openPage()
                .pressSubmit()
                .wasValidate();
    }

}
