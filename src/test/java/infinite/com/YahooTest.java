package infinite.com;

import infinite.com.model.HomePage;
import infinite.com.runner.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class YahooTest extends BaseTest {

    @Test
    public void testYahooSearch() {
        String search = new HomePage(getDriver())
                .searchResult(testData.getSearchCriteria(), HomePage.SearchEngine.YAHOO)
                .getSearchItemText(HomePage.SearchEngine.YAHOO);

        assertEquals(search, testData.getAssertionCriteria());
    }
}


