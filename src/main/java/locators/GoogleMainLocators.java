package locators;
import lombok.Getter;

@Getter
public enum GoogleMainLocators{
    INPUT("//input[@name = 'q']");

    private String path;
    GoogleMainLocators(String path) {
        this.path = path;
    }
}