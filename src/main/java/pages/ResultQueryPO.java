package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import locators.QueryPageLocators;
import org.openqa.selenium.By;
import java.util.LinkedList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class ResultQueryPO {
    private List<ResultQueryComponentPO> listOfResultQuery;
    private SelenideElement nextQueryButton = $(By.id(QueryPageLocators.NEXT_BUTTON_PAGE.getPath()));

    public ResultQueryPO getAddressComponents() {
        if (listOfResultQuery == null) {
            ElementsCollection resultRoots = $$x(QueryPageLocators.LIST_OF_RESULTS.getPath());
            listOfResultQuery = new LinkedList<>();
            for (SelenideElement root : resultRoots) {
                listOfResultQuery.add(new ResultQueryComponentPO(root));
            }
        }
        return this;
    }

    public List<String> getAllTextFromTitleLinks() {
        List<String> result = new LinkedList<>();
        for (ResultQueryComponentPO resultQueryComponent : listOfResultQuery) {
            result.add(resultQueryComponent.getTitleLinkText());
        }
        return result;
    }

    public ResultQueryPO clickOnNextQueryPageButton() {
        nextQueryButton.click();
        return new ResultQueryPO();
    }
}
