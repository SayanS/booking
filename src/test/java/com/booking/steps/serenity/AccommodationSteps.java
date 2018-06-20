package com.booking.steps.serenity;

import com.booking.pages.AccommodationPage;
import com.booking.pages.xpath.AccommodationXpath;
import net.thucydides.core.annotations.Step;

import java.time.LocalDate;

public class AccommodationSteps {

    AccommodationPage accommodationPage;

    @Step
    public void isAccommodationPage() {
        accommodationPage.open(new String[]{"https://www.booking.com/"});
    }

    @Step
    public void enterDestination(String value) {
        accommodationPage.sendKeys(AccommodationXpath.SEARCH_SECTION_DESTINATION_FIELD, value);
    }

    @Step
    public void selectCheckInDateFromToday(Long plusDays) {
        accommodationPage.clickOn(AccommodationXpath.SEARCH_SECTION_CHECKIN_DATE_BUTTON);
        accommodationPage.getSearchSection().selectDate(AccommodationXpath.SEARCH_SECTION_CHECKIN_CALENDAR, LocalDate.now().plusDays(plusDays));
    }

    @Step
    public void selectCheckOutDateFromToday(Long plusDays) {
        accommodationPage.clickOn(AccommodationXpath.SEARCH_SECTION_CHECKOUT_DATE_BUTTON);
        accommodationPage.getSearchSection().selectDate(AccommodationXpath.SEARCH_SECTION_CHECKOUT_CALENDAR, LocalDate.now().plusDays(plusDays));
    }
}
