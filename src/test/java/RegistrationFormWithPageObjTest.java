import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void RegistrationFullFormWithPageObjTest(){

        registrationPage.openPage().setName("Ivan").setLastName("Ivanov").setEmail("IIvanov@gmail.com").setGender("Male")
                        .setUserNumber("0123456789").setDate("1", "January", "2000").setSubjects("Computer Science")
                        .setSubjects("Commerce").setHobbies("Sports").loadPicture("Screen Form.png")
                        .setAddress("Some street 1").setState("Rajasthan").setCity("Jaiselmer").pressSubmit().checkResponseField("Student Name","Ivan Ivanov")
                        .checkResponseField("Student Email", "IIvanov@gmail.com").checkResponseField("Gender", "Male").checkResponseField("Mobile", "0123456789")
                        .checkResponseField("Date of Birth", "01 January,2000").checkResponseField("Subjects", "Computer Science, Commerce")
                        .checkResponseField("Hobbies", "Sports").checkResponseField("Picture", "Screen Form.png")
                        .checkResponseField("Address", "Some street 1").checkResponseField("State and City", "Rajasthan Jaiselmer");
    }


    @Test
    public void RegistrationMinimalFormWithPageObjTest(){

        registrationPage.openPage().setName("Ivan").setLastName("Ivanov").setGender("Male").setUserNumber("0123456789")
                        .setDate("1", "January", "2000").pressSubmit().checkResponseField("Student Name","Ivan Ivanov")
                        .checkResponseField("Gender", "Male").checkResponseField("Mobile", "0123456789")
                        .checkResponseField("Date of Birth", "01 January,2000");

    }


    @Test
    public void RegistrationEmptyFormWithPageObjTest(){

        registrationPage.openPage().pressSubmit().wasValidate();
    }
}
