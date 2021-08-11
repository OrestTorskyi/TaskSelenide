package pages;

import com.codeborne.selenide.SelenideElement;
import locators.ResultQueryComponentLocator;

public class ResultQueryComponentPO {
    private SelenideElement titleLink;

    public ResultQueryComponentPO(SelenideElement root) {
        initElements(root);
    }

    private void initElements(SelenideElement root) {
        titleLink = root.$x(ResultQueryComponentLocator.TITLE_LINK.getPath());
    }

    public String getTitleLinkText() {
        return titleLink.getOwnText();
    }
}
