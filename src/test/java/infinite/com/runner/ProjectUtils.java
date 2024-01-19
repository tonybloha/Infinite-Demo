package infinite.com.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;

public final class ProjectUtils {

    private static final ChromeOptions chromeOptions = new ChromeOptions();

    static WebDriver createDriver() {
        chromeOptions.addArguments("--headless", "--window-size=1920,1080");
        return new ChromeDriver(chromeOptions);
    }

    static void get(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void log(String str) {
        System.out.println(str);
    }

    static TestData readTestDataFromJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), TestData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}