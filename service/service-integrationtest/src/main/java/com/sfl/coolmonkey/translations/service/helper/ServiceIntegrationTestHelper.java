package com.sfl.coolmonkey.translations.service.helper;

import com.sfl.coolmonkey.translations.persistence.repositories.translation.TranslationRepository;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/3/15
 * Time: 4:07 PM
 */
@SuppressWarnings({
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck",
        "squid:S109"
})
@Component
public class ServiceIntegrationTestHelper extends CommonTestHelper {

    //region Constants
    //endregion

    //region Dependencies
    @Autowired
    private TranslationRepository translationRepository;
    //endregion

    //region Constructors
    public ServiceIntegrationTestHelper() {
    }
    //endregion

    //region Translation
    public Translation createAndPersistTranslation() {
        return createAndPersistTranslation("translationLocale" + UUID.randomUUID().toString());
    }

    public Translation createAndPersistTranslation(final String locale) {
        final Translation translation = createTranslation();
        translation.setLocale(locale);
        translation.setId(null);
        return translationRepository.save(translation);
    }

    public Translation createAndPersistTranslation(final String uiLocation, final String key, final String message) {
        final Translation translation = createTranslation(uiLocation, key, message);
        translation.setId(null);
        return translationRepository.save(translation);
    }

    public Translation createAndPersistTranslation(final String locale, final String uiLocation, final String key, final String message) {
        final Translation translation = createTranslation(locale, uiLocation, key, message);
        translation.setId(null);
        return translationRepository.save(translation);
    }
    //endregion

    //endregion
}
