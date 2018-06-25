package com.booking.steps.serenity;

import com.booking.pages.BasePage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalizationSteps {
    BasePage basePage;

    public void isSectionTranslatedInto(String sectionName, String language) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode dictionary;
        List<String> expectedValues=new ArrayList<>();

        dictionary=mapper.readTree(new File("./src/test/resources/data/dictionary.json"));

        dictionary.get(sectionName).get(language).forEach(value->expectedValues.add(value.asText()));

        String[] actual= basePage.getTexts(dictionary.path(sectionName).path("xpath").textValue()).toArray(new String[0]);

        Assert.assertArrayEquals(expectedValues.toArray(),actual);
    }
}


