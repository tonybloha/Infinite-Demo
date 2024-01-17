package infinite.com.runner;

import org.openqa.selenium.WebDriver;;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected TestData testData;

    @BeforeMethod
    protected void beforeMethod() {
        startDriver();
    }

    @BeforeMethod
    protected void beforeTestMethod() {
        testData = ProjectUtils.readTestDataFromJson("src/test/java/infinite/com/data/TestData.json");
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
        ProjectUtils.get(driver);
    }
    protected WebDriver getDriver() {
        return driver;
    }
}
