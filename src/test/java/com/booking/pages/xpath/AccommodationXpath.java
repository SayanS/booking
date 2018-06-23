package com.booking.pages.xpath;

public interface AccommodationXpath {

    final public static String HEADER_SELECT_LANGUAGE_BUTTON="//li[@data-id='language_selector']";
    final public static String HEADER_SELECT_LANGUAGE_BUTTON_IMAGE="//li[@data-id='language_selector']/a/img";

    final public static String SEARCH_SECTION_CHECKIN_DATE_BUTTON="//div[@data-calendar2-type='checkin']";
    final public static String SEARCH_SECTION_CHECKOUT_DATE_BUTTON="//div[@data-calendar2-type='checkout']";

    final public static String SEARCH_SECTION_DESTINATION_FIELD="//input[@id='ss']";

    final public static String SEARCH_SECTION_CHECKIN_CALENDAR="//div[@class='xp__dates-inner xp__dates__checkin']";
    final public static String SEARCH_SECTION_CHECKOUT_CALENDAR="//div[@class='xp__dates-inner xp__dates__checkout']";
    final public static String SEARCH_SECTION_GUEST_INFO_BUTTON="//div[@data-component='search/group/group-with-modal']";

    final public static String SEARCH_SECTION_GUEST_INFO_ROOMS_DROPDOWN="//select[@id='no_rooms']";
    final public static String SEARCH_SECTION_GUEST_INFO_ADULTS_DROPDOWN="//select[@id='group_adults']";
    final public static String SEARCH_SECTION_GUEST_INFO_CHILDREN_DROPDOWN="//select[@id='group_children']";
    final public static String SEARCH_SECTION_GUEST_INFO_AGES_DROPDOWN="(//select[@name='age'])";

    final public static String SEARCH_SECTION_SEARCH_BUTTON="//div[contains(@class,'sb-searchbox-submit-col -submit-button')]/button";



}
