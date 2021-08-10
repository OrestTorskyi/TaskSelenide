package locators;
import lombok.Getter;

@Getter
public enum QueryPageLocators {
    LIST_OF_RESULTS("//div[@class = 'g']//h3"),
    NEXT_BUTTON_PAGE("pnnext");

    private String path;
    QueryPageLocators(String path) {
        this.path = path;
    }
}
