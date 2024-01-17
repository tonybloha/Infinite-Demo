package infinite.com;

import infinite.com.model.HomePage;
import infinite.com.runner.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GoogleTest extends BaseTest {

    @Test
    public void testGoogle() {
        String search = new HomePage(getDriver())
                .searchResult(testData.getSearchCriteria())
                .getSearchItemText();

        assertEquals(search, testData.getAssertionCriteria());
    }
}

