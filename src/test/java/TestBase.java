import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void setUpPreconditions() {
        Configuration.baseUrl = System.getProperty("url_regform");
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browser_version");
        Configuration.browserSize = System.getProperty("permission");
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "https://user1:1234@" + System.getProperty("url_selenoid") + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
