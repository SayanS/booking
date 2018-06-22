package com.booking.steps;

import com.booking.steps.serenity.LocalizationSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class LocalizationStepDefs {

    @Steps
    LocalizationSteps localizationSteps;

    @Then("^Texts of \"([^\"]*)\" should be translated into \"([^\"]*)\"$")
    public void textsOfShouldBeTranslatedInto(String sectionName, String language) throws IOException {
        localizationSteps.isSectionTranslatedInto(sectionName, language);
    }
}
