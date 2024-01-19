package infinite.com;

import infinite.com.model.HomePage;
import infinite.com.model.HomePage.SearchEngine;
import infinite.com.runner.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class BingTest extends BaseTest {

        @Test
        public void testBingSearch() {
            String search = new HomePage(getDriver())
                    .searchResult(testData.getSearchCriteria(), SearchEngine.BING)
                    .getSearchItemText(SearchEngine.BING);

            assertEquals(search, testData.getAssertionCriteria());
        }
}

