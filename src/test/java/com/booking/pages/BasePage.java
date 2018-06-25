package com.booking.pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends PageObject {

    public List<String> getTexts(String xpath){
        List<String> textValues=new ArrayList<>();
        findAll(xpath).forEach(webElement->textValues.add(webElement.getText()));
        return textValues;
    }

    public String getText(String xpath){
        return findBy(xpath).getText();
    }

    public String getText(String xpath, String keyWordXpath){
        return getText(xpath.replace("$KeyWord", keyWordXpath));
    }

    public void clickOnJS(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", findBy(xpath));
    }

    public void scrollIntoView(String xpath, int offset_y) {
        int y = getDriver().findElement(By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, " + y + ")");
    }

    public void scrollIntoView(String xpath) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0)");
    }

    public void clickOn(String xpath) {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),5);
        scrollIntoView(xpath, -100);
        moveTo(xpath);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), 3);
        $(xpath).click();
    }

    public void clickOn(String xpath, String keyWordXpath) {
        clickOn(xpath.replace("$KeyWord",keyWordXpath));
    }

    protected <V> V waitFor(Function<? super WebDriver,V> condition, int secTimeout){
            return  (new WebDriverWait(getDriver(),secTimeout)).until(condition);
    }

    public void sendKeys(String xpath, String value){
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), 5);
        scrollIntoView(xpath);
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), 3);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), 3);
        $(xpath).sendKeys(value);
    }

    public void moveTo(WebElementFacade webElementFacade){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(webElementFacade).perform();
    }

    public String getAttribute(String xpath, String attribute) {
        return $(xpath).getAttribute(attribute);
    }

    public String getCurrentLanguage(){
        return getDriver().findElement(By.xpath("//html")).getAttribute("lang");
    }

    public String getCurrentLangTranslation(String dictionaryPath, String text){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode dictionary=null;
        try {
            dictionary=mapper.readTree(new File(dictionaryPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary.get(text).get(getCurrentLanguage()).textValue();
    }

    public void selectFromDropDownByValue(String xpath, String value){
        $(xpath).selectByValue(value);
    }
}
