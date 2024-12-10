import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void RegistrationFullFormWithPageObjTest(){

        registrationPage.openPage().setName("Ivan").setLastName("Ivanov").setEmail("IIvanov@gmail.com").setGender("Male")
                        .setUserNumber("0123456789").setDate("1", "January", "2000").setSubjects("Computer Science")
                        .setSubjects("Commerce").setHobbies("Sports").loadPicture("Screen Form.png")
                        .setAddress("Some street 1").setState("Rajasthan").setCity("Jaiselmer").pressSubmit();

    }



}
