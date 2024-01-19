package infinite.com.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends HomePage {

    @FindBy(className = "kno-rdesc")
    private WebElement googleSearchItem;

    @FindBy(xpath = "//div[@id='5694']")
    private WebElement bingSearchItem;

    @FindBy(xpath = "//div[@class = 'compText mt-16 mb-16 cl-b fc-falcon pl-15 pr-15 fz-13 lh-16']")
    private WebElement yahooSearchItem;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchItemText(SearchEngine searchEngine) {
        WebElement searchItem = switch (searchEngine) {
            case GOOGLE -> googleSearchItem;
            case BING -> bingSearchItem;
            case YAHOO -> yahooSearchItem;
        };

        String result = getWait2().until(ExpectedConditions.visibilityOf(searchItem)).getText();
        return result.substring(result.indexOf("is"), result.indexOf("and")).trim();
    }
}
