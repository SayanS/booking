package com.booking.pages.sections;

import com.booking.pages.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.time.LocalDate;

public class SearchSection extends BasePage {
    private String NEXT_MONTH_BUTTON = "//div[contains(@class,'c2-button c2-button-further')]/span";
    private String PREV_MONTH_BUTTON = "//div[contains(@class='c2-button c2-button-earlier')]//span";

    public void selectDate(String xpathCalendar, LocalDate date) {
        String monthYear = date.getMonth().toString().toLowerCase() + " " + String.valueOf(date.getYear());
        monthYear = monthYear.replaceFirst(monthYear.substring(0, 1), String.valueOf(Character.toUpperCase(monthYear.charAt(0))));
        String dayXpath = xpathCalendar+"//th[contains(text(),'" + monthYear + "')]/ancestor::table//td/span";
        while (!$(NEXT_MONTH_BUTTON).hasClass("c2-button-s-disabled")) {
            if (isElementVisible(By.xpath(xpathCalendar+"//th[contains(text(),'" + monthYear + "')]")) == false) {
                clickOn(NEXT_MONTH_BUTTON);
            } else {
                break;
            }
        }
        for (WebElementFacade day : findAll(dayXpath)) {
            if (day.getText().equals(String.valueOf(date.getDayOfMonth()))) {
                moveTo(day);
                day.click();
                break;
            }
        }
    }


    public void selectGuestInfoFromDropdown(String xpathDropdown, String value) {
        selectFromDropdown($(xpathDropdown),value);
    }

}
