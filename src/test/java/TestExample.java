import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import locators.GoogleMainLocators;
import locators.QueryPageLocators;
import locators.WelcomePageLocators;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class TestExample {
    SoftAssert softAssert;

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
    public void testExample() {
        $x(GoogleMainLocators.INPUT.getPath()).setValue("funny kitten").pressEnter();
        List<String> resultList = new LinkedList<>();
        while (resultList.size() < 10) {
            ElementsCollection listOfResults = $$x(QueryPageLocators.LIST_OF_RESULTS.getPath());
            for (SelenideElement element : listOfResults) {
                resultList.add(element.getOwnText());
            }
            $(By.id(QueryPageLocators.NEXT_BUTTON_PAGE.getPath())).click();
        }
        softAssert.assertTrue(resultList.get(0).toLowerCase().contains("kitten"));
        softAssert.assertTrue(resultList.get(9).toLowerCase().contains("kitten"));
        softAssert.assertAll();
    }
}
