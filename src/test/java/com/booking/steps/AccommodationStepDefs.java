package com.booking.steps;

import com.booking.steps.serenity.AccommodationSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AccommodationStepDefs {

    @Steps
    AccommodationSteps accommodationSteps;

    @Given("^Accommodation page is opened$")
    public void accommodationPageIsOpened(){
       accommodationSteps.isAccommodationPage();
    }

    @When("^Enter \"([^\"]*)\" to search$")
    public void enterToSearch(String value) {
        accommodationSteps.enterDestination(value);
    }

    @When("^Select Check-in date to search \"([^\"]*)\" day from today$")
    public void selectCheckInDateToSearchDayFromToday(Long plusDays){
      accommodationSteps.selectCheckInDateFromToday(plusDays);
    }

    @When("^Select Check-out date \"([^\"]*)\" day from Today$")
    public void selectCheckOutDateDayFromToday(Long plusDays){
        accommodationSteps.selectCheckOutDateFromToday(plusDays);
    }
}
