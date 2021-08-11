package locators;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GoogleMainLocator {
    INPUT("//input[@name = 'q']");

    @NonNull
    private String path;
}