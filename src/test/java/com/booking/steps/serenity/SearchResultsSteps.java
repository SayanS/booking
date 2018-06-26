package com.booking.steps.serenity;

import com.booking.pages.SearchResultsPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.booking.pages.xpath.SearchResultsXpath.*;

public class SearchResultsSteps {
    SearchResultsPage searchResultsPage;

    @Step
    public void selectFilter(String filterName, String optionNum) {
        searchResultsPage.selectFilterOption(filterName,optionNum);
    }

    @Step
    public void clickOnHotelNameOfItem(String itemNumber) {
        Serenity.getCurrentSession().put("ClickedHotelName",searchResultsPage.getText(HOTEL_NAMES+"["+itemNumber+"]"));
        Serenity.getCurrentSession().put("ClickedHotelHref",searchResultsPage.getAttribute(HOTEL_NAMES_LINKS+"["+itemNumber+"]","href"));
        searchResultsPage.clickOn(HOTEL_NAMES_LINKS+"["+itemNumber+"]");
    }

    @Step
    public void isTitleContains(String text) {
        Assert.assertEquals(text, searchResultsPage.getText(searchResultsPage.PAGE_TITLE).split(":")[0]);
    }
}
