package com.booking.steps.serenity;

import com.booking.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;

public class SearchResultsSteps {
    SearchResultsPage searchResultsPage;

    @Step
    public void selectFilter(String filterName, String optionNum) {
        searchResultsPage.selectFilterOption(filterName,optionNum);
        int i=0;
    }
}
