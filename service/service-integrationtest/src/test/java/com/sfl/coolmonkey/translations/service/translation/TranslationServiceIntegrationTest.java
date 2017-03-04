package com.sfl.coolmonkey.translations.service.translation;

import com.sfl.coolmonkey.translations.persistence.repositories.translation.TranslationRepository;
import com.sfl.coolmonkey.translations.service.test.AbstractServiceIntegrationTest;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 8:16 PM
 */
public class TranslationServiceIntegrationTest extends AbstractServiceIntegrationTest {

    //region Dependencies
    @Autowired
    private TranslationService translationService;

    @Autowired
    private TranslationRepository translationRepository;
    //endregion

    //region Constructors
    public TranslationServiceIntegrationTest() {
    }
    //endregion

    //region Test methods
    @Test
    public void testGetById() {
        // prepared data
        final Translation translation = getHelper().createAndPersistTranslation();
        // run test scenario
        final Translation result = translationService.getById(translation.getId());
        assertNotNull(result);
        assertEquals(translation, result);
    }

    @Test
    public void testGetByUuid() {
        // prepared data
        final Translation translation = getHelper().createAndPersistTranslation();
        // run test scenario
        final Translation result = translationService.getByUuid(translation.getUuid());
        assertNotNull(result);
        assertEquals(translation, result);
    }

    @Test
    public void testGetAllByLocale() {
        // prepared data
        final Translation translation = getHelper().createAndPersistTranslation();
        final String locale = translation.getLocale();
        // should not be retrieved because is different locale
        getHelper().createAndPersistTranslation("anotherLocale");
        // should not be retrieved because is deleted
        final Translation removedTranslation = getHelper().createAndPersistTranslation(locale, "DeletedUiLocation", "DeletedKey", "DeletedMessage");
        removedTranslation.setRemoved(new Date());
        translationRepository.save(removedTranslation);
        flushAndClear();
        // run test scenario
        final List<Translation> result = translationService.getAllByLocale(locale);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(translation.getUuid(), result.get(0).getUuid());
    }

    @Test
    public void testGetByUiLocationKeyLocale() {
        // prepared data
        final Translation translation = getHelper().createAndPersistTranslation();
        final String locale = translation.getLocale();
        final String uiLocation = translation.getUiLocation();
        final String key = translation.getKey();
        // different translation
        getHelper().createAndPersistTranslation("anotherLocale");
        // run test scenario
        final Translation result = translationService.getByUiLocationKeyLocale(uiLocation, key, locale);
        assertNotNull(result);
        assertEquals(translation.getUuid(), result.getUuid());
    }

    @Test
    public void testGetAllUiLocations() {
        // prepared data
        getHelper().createAndPersistTranslation("uiLocation1", "key1", "message");
        getHelper().createAndPersistTranslation("uiLocation2", "key1", "message");
        getHelper().createAndPersistTranslation("uiLocation2", "key2", "message");
        // run test scenario
        final List<String> result = translationService.getAllUiLocations();
        assertNotNull(result);
        assertEquals(Arrays.asList("uiLocation1", "uiLocation2"), result);
    }

    @Test
    public void testGetAllByLocaleAndUiLocation() {
        // prepared data
        getHelper().createAndPersistTranslation("en-us", "location1", "key", "message-en");
        getHelper().createAndPersistTranslation("en-us", "location2", "key", "message-en");
        getHelper().createAndPersistTranslation("nl-nl", "location1", "key", "message-nl");
        final Translation translation1 =
                getHelper().createAndPersistTranslation("nl-nl", "location2", "key", "message-nl");
        final Translation translation2 =
                getHelper().createAndPersistTranslation("nl-nl", "location2", "key2", "message-nl");
        final String locale = "nl-nl";
        final String uiLocation = "location2";
        // run test scenario
        final List<Translation> result = translationService.getAllByLocaleAndUiLocation(locale, uiLocation);
        assertNotNull(result);
        assertEquals(Arrays.asList(translation1, translation2), result);
    }

    @Test
    public void testUpdateMessage() {
        // prepared data
        final String message = "newMessage";
        final Translation translation = getHelper().createAndPersistTranslation("en-us", "location1", "key", "message-en");
        final String uuid = translation.getUuid();
        // run test scenario
        translationService.updateMessage(uuid, message);
        final Translation result = translationService.getByUuid(uuid);
        assertNotNull(result);
        assertEquals(message, result.getMessage());
    }

    @Test
    public void testGetAllForIndexation() {
        // prepare test data
        final Translation translation1 = getHelper().createAndPersistTranslation();
        final Translation translation2 = getHelper().createAndPersistTranslation();
        final Translation translation3 = getHelper().createAndPersistTranslation();
        final Translation translation4 = getHelper().createAndPersistTranslation();
        final Translation translation5 = getHelper().createAndPersistTranslation();
        final Translation translation6 = getHelper().createAndPersistTranslation();
        translation6.setRemoved(new Date());
        translationRepository.save(translation6);
        flushAndClear();
        // run test scenario
        List<Translation> result;
        result = translationService.getAllForIndexation(0, 2);
        assertEquals(Arrays.asList(translation1, translation2), result);
        result = translationService.getAllForIndexation(1, 2);
        assertEquals(Arrays.asList(translation3, translation4), result);
        result = translationService.getAllForIndexation(2, 2);
        assertEquals(Collections.singletonList(translation5), result);
        result = translationService.getAllForIndexation(0, 6);
        assertFalse(result.contains(translation6));
    }

    @Test
    public void testGetReallyAll() {
        // prepare test data
        final Translation translation1 = getHelper().createAndPersistTranslation();
        final Translation translation2 = getHelper().createAndPersistTranslation();
        final Translation translation3 = getHelper().createAndPersistTranslation();
        final Translation translation4 = getHelper().createAndPersistTranslation();
        final Translation translation5 = getHelper().createAndPersistTranslation();
        final Translation translation6 = getHelper().createAndPersistTranslation();
        flushAndClear();
        // run test scenario
        List<Translation> result = translationService.getAll();
        assertEquals(result.size(), 6);
    }
    //endregion
}
