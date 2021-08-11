package locators;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QueryPageLocators {
    LIST_OF_RESULTS("//div[@class = 'g']"),
    NEXT_BUTTON_PAGE("pnnext"),
    LOGO("logo");

    @NonNull
    private String path;
}
