package infinite.com.model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseModel {

    @FindBy(id = "APjFqb")
    private WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchResult(String itemToSearch) {
        searchBar.sendKeys(itemToSearch);
        searchBar.sendKeys(Keys.RETURN);
        return new SearchResultPage(getDriver());
    }
}
