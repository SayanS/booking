package com.booking.pages;

public class SearchResultsPage extends BasePage {
    private String dictionaryPathFilter = "./src/test/resources/data/SearchResultsFiltersDictionary.json";

    public void selectFilterOption(String filterName, String optionNum) {
        String filterContainerXpath = "//p[contains(text(),'" + getCurrentLangTranslation(dictionaryPathFilter, filterName) + "') and @class='filtercategory-title']/ancestor::div[2]";
        String optionXpath = filterContainerXpath + "//a["+optionNum+"]";
        $(optionXpath).click();
    }
}




