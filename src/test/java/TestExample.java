import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import locators.GoogleMainLocators;
import locators.QueryPageLocators;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.GoogleMainPO;
import pages.ResultQueryPO;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TestExample {
    private SoftAssert softAssert;

    @Parameters("browser")
    @BeforeTest
    public void setUpDriver(String browser) {
        Configuration.browser = browser;
    }

    @AfterTest
    public void tearDownDriver() {
        Selenide.closeWebDriver();
    }

    @BeforeClass
    public void setUp() {
        open("https://www.google.com.ua/");
        softAssert = new SoftAssert();
    }

    @Test
    public void verifyTextOfResultQuery() {
        var query = "funny kitten";
        var expectedText = "kitten";
        ResultQueryPO resultQueryPO = new GoogleMainPO()
                .searchQuery(query)
                .getAddressComponents();
        var resultList = new LinkedList<String>();
        resultList.addAll(resultQueryPO.getAllTextFromTitleLinks());
        if (resultList.size() < 10) {
            resultList.addAll(resultQueryPO.
                    clickOnNextQueryPageButton()
                    .getAddressComponents()
                    .getAllTextFromTitleLinks());
        }
        softAssert.assertTrue(resultList.get(0).toLowerCase().contains(expectedText));
        softAssert.assertTrue(resultList.get(9).toLowerCase().contains(expectedText));
        softAssert.assertAll();
    }
}