package com.booking.pages.sections;

import net.thucydides.core.pages.PageObject;

public class SelectLanguagePopUp extends PageObject {

    public boolean isCurrentLanguage(String language) {
        String LANGUAGE_IN_SECTION_ALL = "(//div[@id='current_language']//div[@class='select_foldout_wrap'])[2]//li[@data-lang='" + language + "']";
        if ($(LANGUAGE_IN_SECTION_ALL).getCssValue("background").contains("rgb(237, 237, 237)")) {
            return true;
        } else {
            return false;
        }
    }
}
