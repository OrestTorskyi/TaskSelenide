package pages;

import com.codeborne.selenide.SelenideElement;
import locators.GoogleMainLocator;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleMainPO {
    private SelenideElement inputQuery = $x(GoogleMainLocator.INPUT.getPath());

    public ResultQueryPO searchQuery(String query) {
        inputQuery.setValue(query).pressEnter();
        return new ResultQueryPO();
    }
}
