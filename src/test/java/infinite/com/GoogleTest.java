package infinite.com;

import infinite.com.model.HomePage;
import infinite.com.model.HomePage.SearchEngine;
import infinite.com.runner.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GoogleTest extends BaseTest {
    @Test
    public void testGoogleSearch() {
        String search = new HomePage(getDriver())
                .searchResult(testData.getSearchCriteria(), SearchEngine.GOOGLE)
                .getSearchItemText(SearchEngine.GOOGLE);

        assertEquals(search, testData.getAssertionCriteria());
    }
}




