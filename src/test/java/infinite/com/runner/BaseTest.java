package infinite.com.runner;

import org.openqa.selenium.WebDriver;;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected TestData testData;
    protected String baseUrl;

    @BeforeMethod
    protected void beforeMethod() {
        testData = ProjectUtils.readTestDataFromJson("src/test/java/infinite/com/data/TestData.json");
        setBaseUrl();
        startDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        closeDriver();
    }

    protected void startDriver() {
        ProjectUtils.log("Browser open");
        driver = ProjectUtils.createDriver();
        getWeb();
    }

    protected void closeDriver() {
        if (driver == null) {
            return;
        }

        ProjectUtils.log("Browser closed");
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    protected void getWeb() {
        ProjectUtils.log("Get web page");
        ProjectUtils.get(driver,baseUrl);
    }


private void setBaseUrl() {
    switch (getClass().getSimpleName()) {
        case "GoogleTest" -> baseUrl = "https://www.google.com";
        case "BingTest" -> baseUrl = "https://www.bing.com";
        case "YahooTest" -> baseUrl = "https://www.yahoo.com";
        default -> baseUrl = "https://www.google.com";
    }
}


    protected WebDriver getDriver() {
        return driver;
    }
}

