package com.booking.steps.serenity;

import com.booking.pages.AccommodationPage;
import com.booking.pages.xpath.AccommodationXpath;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import static com.booking.pages.xpath.AccommodationXpath.*;

public class AccommodationSteps {

    AccommodationPage accommodationPage;

    @Step
    public void isAccommodationPage() {
        Properties prop=new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("serenity.properties");
            prop.load(input);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        accommodationPage.openUrl(prop.getProperty("webdriver.base.url"));
    }

    @Step
    public void enterDestination(String value) {
        accommodationPage.sendKeys(SEARCH_SECTION_DESTINATION_FIELD, value);
    }

    @Step
    public void selectCheckInDateFromToday(Long plusDays) {
        accommodationPage.clickOn(SEARCH_SECTION_CHECKIN_DATE_BUTTON);
        accommodationPage.getSearchSection().selectDate(SEARCH_SECTION_CHECKIN_CALENDAR, LocalDate.now().plusDays(plusDays));
    }

    @Step
    public void selectCheckOutDateFromToday(Long plusDays) {
        accommodationPage.clickOn(SEARCH_SECTION_CHECKOUT_DATE_BUTTON);
        accommodationPage.getSearchSection().selectDate(SEARCH_SECTION_CHECKOUT_CALENDAR, LocalDate.now().plusDays(plusDays));
    }

    @Step
    public void selectGuestsInfoToSearch(String rooms, String adults, String children, List<String> chldAges) {
        accommodationPage.clickOn(SEARCH_SECTION_GUEST_INFO_BUTTON);
        accommodationPage.getSearchSection().selectGuestInfoFromDropdown(SEARCH_SECTION_GUEST_INFO_ADULTS_DROPDOWN, adults);
        accommodationPage.getSearchSection().selectGuestInfoFromDropdown(SEARCH_SECTION_GUEST_INFO_CHILDREN_DROPDOWN, children);
        accommodationPage.getSearchSection().selectGuestInfoFromDropdown(SEARCH_SECTION_GUEST_INFO_ROOMS_DROPDOWN, rooms);
        for (int i = 0; i < chldAges.size(); i++) {
            accommodationPage.getSearchSection()
                    .selectGuestInfoFromDropdown(SEARCH_SECTION_GUEST_INFO_AGES_DROPDOWN + "[" + (i + 1) + "]", chldAges.get(i) + " years old");
        }
    }

    @Step
    public void clickOnSearchDestinationButton() {
        accommodationPage.getSearchSection().clickOn(SEARCH_SECTION_SEARCH_BUTTON);
    }

    @Step
    public void setCurrentLanguage(String language) {
        accommodationPage.clickOn(AccommodationXpath.HEADER_SELECT_LANGUAGE_BUTTON);
        accommodationPage.selectCurrentLanguage(language);
        int i=0;
    }

    @Step
    public void clickOnSelectLanguageButton() {
        accommodationPage.clickOn(AccommodationXpath.HEADER_SELECT_LANGUAGE_BUTTON);
    }

    @Step
    public void isCurrentLanguageInLanguageSelectorPopup(String language) {
        Assert.assertTrue(accommodationPage.getSelectLanguagePopUp().isCurrentLanguage(language));
    }

    @Step
    public void isImageShownOnCurrentLanguageButton(String imageUrl) {
        Assert.assertEquals(imageUrl,accommodationPage.getAttribute(AccommodationXpath.HEADER_SELECT_LANGUAGE_BUTTON_IMAGE,"src"));
    }
}
