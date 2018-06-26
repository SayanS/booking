package com.booking.steps;

import com.booking.steps.serenity.HotelDetailsSteps;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class HotelDetailsStepdefs {
    @Steps
    HotelDetailsSteps hotelDetailsSteps;

    @Then("^Hotel details page should be opened in a new browser tab with the title of clicked Hotel name$")
    public void hotelDetailsPageShouldBeOpenedInANewBrowserTabWithTheTitleOfClickedHotelName(){
      hotelDetailsSteps.isTitle((String) Serenity.getCurrentSession().get("ClickedHotelName"));
    }

    @Then("^Hotel details page should contain \"([^\"]*)\" in Hotel address$")
    public void hotelDetailsPageShouldContainInHotelAddress(String text) {
        hotelDetailsSteps.isHotelAddressContains(text);
    }

    @Then("^Appropriate Hotel details page should be opened in a new browser tab$")
    public void appropriateHotelDetailsPageShouldBeOpenedInANewBrowserTab() {
        String expectedUrl= (String) Serenity.getCurrentSession().get("ClickedHotelHref");
        hotelDetailsSteps.isNewTabHotelDetailsPageOpened(expectedUrl);
    }
}
