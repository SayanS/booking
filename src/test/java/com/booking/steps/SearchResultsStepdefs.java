package com.booking.steps;

import com.booking.steps.serenity.SearchResultsSteps;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchResultsStepdefs {
    @Steps
    SearchResultsSteps searchResultsSteps;

    @When("^Select option number \"([^\"]*)\" of the \"([^\"]*)\" Search results filter$")
    public void selectOptionNumberOfTheSearchResultsFilter(String value, String filterName){
      searchResultsSteps.selectFilter(filterName, value);
    }
}
