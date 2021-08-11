package locators;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultQueryComponentLocators {
    TITLE_LINK(".//h3");

    @NonNull
    private String path;
}
