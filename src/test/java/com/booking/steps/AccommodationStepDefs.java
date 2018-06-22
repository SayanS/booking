package com.booking.steps;

import com.booking.steps.serenity.AccommodationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccommodationStepDefs {

    @Steps
    AccommodationSteps accommodationSteps;

    @Given("^Accommodation page is opened$")
    public void accommodationPageIsOpened() {
        accommodationSteps.isAccommodationPage();
    }

    @When("^Enter \"([^\"]*)\" to search$")
    public void enterToSearch(String value) {
        accommodationSteps.enterDestination(value);
    }

    @When("^Select Check-in date to search \"([^\"]*)\" day from today$")
    public void selectCheckInDateToSearchDayFromToday(Long plusDays) {
        accommodationSteps.selectCheckInDateFromToday(plusDays);
    }

    @When("^Select Check-out date \"([^\"]*)\" day from Today$")
    public void selectCheckOutDateDayFromToday(Long plusDays) {
        accommodationSteps.selectCheckOutDateFromToday(plusDays);
    }

    @When("^Select guests info \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" to search$")
    public void selectGuestsInfoToSearch(String rooms, String adults, String children, String ages) {
        List<String> chldAges = new ArrayList<String>();
        chldAges = Arrays.asList(ages.replaceAll(" ", "").split(","));
        accommodationSteps.selectGuestsInfoToSearch(rooms, adults, children, chldAges);
    }

    @When("^Click on Search destination button$")
    public void clickOnSearchDestinationButton(){
        accommodationSteps.clickOnSearchDestinationButton();
    }

    @When("^Select \"([^\"]*)\" as current language$")
    public void selectAsCurrentLanguage(String language) {
        accommodationSteps.setCurrentLanguage(language);
    }

}
