import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
    }

    /*@AfterAll
    static void afterAll() throws IOException {
        Files.walk(Path.of("dir_path")).filter(Files::isRegularFile).forEach(p -> {
            try {
                Files.delete(p);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });
    }*/
}
