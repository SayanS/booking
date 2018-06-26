package com.booking.pages.xpath;

public interface SearchResultsXpath {
    final public static String HOTEL_NAMES_LINKS="(//h3/a[@class='hotel_name_link url'])";
    final public static String HOTEL_NAMES="("+HOTEL_NAMES_LINKS+ "/span[contains(@class,'sr-hotel__name')])";
}
