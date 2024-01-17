package infinite.com.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends HomePage{

    @FindBy(className = "hgKElc")
    private WebElement searchItem;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchItemText () {
        String result = getWait2().until(ExpectedConditions.visibilityOf(searchItem)).getText();
        return result.substring(0,result.indexOf("."));
    }
}
