package locators;

public enum WelcomePageLocators {
    FIRSTNAME("//div[contains(@class, 'homepage')]//input[@id = 'edit-submitted-firstname']"),
    LASTNAME("//div[contains(@class, 'homepage')]//input[@id = 'edit-submitted-lastname']"),
    EMAIL("//div[contains(@class, 'homepage')]//input[@id = 'edit-submitted-email']"),
    TELEPHONE("//div[contains(@class, 'homepage')]//input[@id = 'edit-submitted-homephone']"),
    ZIP_CODE("//div[contains(@class, 'homepage')]//input[@id = 'edit-submitted-zip']");

    private String path;

    WelcomePageLocators(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
