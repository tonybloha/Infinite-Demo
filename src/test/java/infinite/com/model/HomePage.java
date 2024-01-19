package infinite.com.model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseModel {

    @FindBy(id = "APjFqb")
    private WebElement googleSearchBar;

    @FindBy(css = "#sb_form_q")
    private WebElement bingSearchBar;

    @FindBy(id = "ybar-sbq")
    private WebElement yahooSearchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage searchResult(String itemToSearch, SearchEngine searchEngine) {
        WebElement searchBar = switch (searchEngine) {
            case GOOGLE -> googleSearchBar;
            case BING -> bingSearchBar;
            case YAHOO -> yahooSearchBar;
        };

        searchBar.sendKeys(itemToSearch);
        searchBar.sendKeys(Keys.RETURN);
        return new SearchResultPage(getDriver());
    }

    public enum SearchEngine {
        GOOGLE, BING, YAHOO
    }

    public WebElement getGoogleSearchBar() {
        return googleSearchBar;
    }

    public WebElement getBingSearchBar() {
        return bingSearchBar;
    }

    public WebElement getYahooSearchBar() {
        return yahooSearchBar;
    }
}


