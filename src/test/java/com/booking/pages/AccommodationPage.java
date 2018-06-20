package com.booking.pages;

import com.booking.pages.sections.SearchSection;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.booking.com/")
public class AccommodationPage extends BasePage {

    private SearchSection searchSection;

    public SearchSection getSearchSection() {
        return searchSection;
    }
}
