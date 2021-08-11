package pages;

import com.codeborne.selenide.SelenideElement;
import locators.ResultQueryComponentLocators;

public class ResultQueryComponentPO {
    private SelenideElement titleLink;

    public ResultQueryComponentPO(SelenideElement root) {
        initElements(root);
    }

    private void initElements(SelenideElement root) {
        titleLink = root.$x(ResultQueryComponentLocators.TITLE_LINK.getPath());
    }

    public String getTitleLinkText() {
        return titleLink.getOwnText();
    }
}
