package com.booking.steps;

import com.booking.steps.serenity.SearchResultsSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchResultsStepdefs {
    @Steps
    SearchResultsSteps searchResultsSteps;

    @When("^Select option number \"([^\"]*)\" of the \"([^\"]*)\" Search results filter$")
    public void selectOptionNumberOfTheSearchResultsFilter(String value, String filterName){
      searchResultsSteps.selectFilter(filterName, value);
    }

    @When("^Click on Hotel name of the \"([^\"]*)\" item in the Search results$")
    public void clickOnHotelNameOfTheItemInTheSearchResults(String itemNumber) {
        searchResultsSteps.clickOnHotelNameOfItem(itemNumber);
    }

    @Then("^The title of Search results page should contain \"([^\"]*)\"$")
    public void theTitleOfSearchResultsPageShouldContain(String text){
        searchResultsSteps.isTitleContains(text);
    }
}
