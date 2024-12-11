import org.junit.jupiter.api.Test;
import pages.TestBoxPages;

public class TextBoxPageObjTests extends TestBase {

    TestBoxPages testBoxPages = new TestBoxPages();


    @Test
    public void textBoxPageObjTest() {

        testBoxPages.openPage().setName("Alex").setEmail("alex@egorov.com").setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1").pressSubmit().checkOutputForm("Alex")
                .checkOutputForm("alex@egorov.com").checkOutputForm("Some street 1")
                .checkOutputForm("Another street 1");
    }
}
