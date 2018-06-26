package com.booking.steps.serenity;

import com.booking.pages.HotelDetailsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.regex.Pattern;

public class HotelDetailsSteps {
    HotelDetailsPage hotelDetailsPage;

    @Step
    public void isTitle(String clickedHotelName) {
        Assert.assertEquals(clickedHotelName, hotelDetailsPage.getText(hotelDetailsPage.HOTEL_TITLE));
    }

    @Step
    public void isHotelAddressContains(String text) {
        Assert.assertTrue(hotelDetailsPage.getText(hotelDetailsPage.HOTEL_ADDRESS) + " - Address isn't contained: " + text, hotelDetailsPage.getText(hotelDetailsPage.HOTEL_ADDRESS).contains(text));
    }

    @Step
    public void isNewTabHotelDetailsPageOpened(String url) {
        String actualUrl = hotelDetailsPage.switchToLustWindow().split(Pattern.quote("?"))[0];
        String expectedUrl = url.split(Pattern.quote("?"))[0];
        System.out.println(expectedUrl);
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
