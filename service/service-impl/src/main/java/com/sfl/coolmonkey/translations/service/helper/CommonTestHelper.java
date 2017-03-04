package com.sfl.coolmonkey.translations.service.helper;

import com.sfl.coolmonkey.translations.service.translation.model.Translation;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 8/21/15
 * Time: 8:33 PM
 */
@SuppressWarnings({
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck",
        "squid:S109"
})
public class CommonTestHelper {

    //region Constructors
    public CommonTestHelper() {
    }
    //endregion

    //region Public methods

    //region Translation
    public Translation createTranslation() {
        return createTranslation("uiLocation");
    }

    public Translation createTranslation(final String uiLocation) {
        return createTranslation(uiLocation, "key", "message");
    }

    public Translation createTranslation(final String uiLocation, final String key, final String message) {
        return createTranslation("locale", uiLocation, key, message);
    }

    public Translation createTranslation(final String locale, final String uiLocation, final String key, final String message) {
        final Translation translation = new Translation();
        translation.setId(1L);
        translation.setKey(key);
        translation.setLocale(locale);
        translation.setUiLocation(uiLocation);
        translation.setMessage(message);
        return translation;
    }
    //endregion

    //endregion
}
