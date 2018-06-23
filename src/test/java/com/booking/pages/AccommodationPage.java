package com.booking.pages;

import com.booking.pages.sections.SearchSection;
import com.booking.pages.sections.SelectLanguagePopUp;

public class AccommodationPage extends BasePage {

    private SearchSection searchSection;
    private SelectLanguagePopUp selectLanguagePopUp;

    public SearchSection getSearchSection() {
        return searchSection;
    }

    public SelectLanguagePopUp getSelectLanguagePopUp(){
        return selectLanguagePopUp;
    }

    public void selectCurrentLanguage(String language) {
        $("(//div[@class='select_foldout_wrap'])[2]//ul/li/a[@hreflang='"+language+"']").click();
    }


}
