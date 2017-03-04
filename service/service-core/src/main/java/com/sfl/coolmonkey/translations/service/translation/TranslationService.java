package com.sfl.coolmonkey.translations.service.translation;

import com.sfl.coolmonkey.translations.service.translation.model.Translation;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 5:31 PM
 */
public interface TranslationService {

    /**
     * Gets translation by provided id
     *
     * @param id
     * @return
     */
    @Nonnull
    Translation getById(@Nonnull final Long id);

    /**
     * Gets translation by provided uuid
     *
     * @param uuid
     * @return
     */
    @Nonnull
    Translation getByUuid(@Nonnull final String uuid);

    /**
     * Returns a list of all translations by given locale. Examples of locale: en-us, nl-nl
     *
     * @param locale
     * @return translations
     */
    @Nonnull
    List<Translation> getAllByLocale(@Nonnull final String locale);

    /**
     * Returns a list of all translations by given locale and ui location
     *
     * @param locale
     * @param uiLocation
     * @return
     */
    @Nonnull
    List<Translation> getAllByLocaleAndUiLocation(@Nonnull final String locale, @Nonnull final String uiLocation);

    /**
     * Returns a translation which matches given parameters
     *
     * @param uiLocation
     * @param key
     * @param locale
     * @return translation
     */
    @Nonnull
    Translation getByUiLocationKeyLocale(@Nonnull final String uiLocation, @Nonnull final String key, @Nonnull final String locale);

    /**
     * Returns a list of all ui locations in database
     *
     * @return ui locations
     */
    @Nonnull
    List<String> getAllUiLocations();

    /**
     * Updates given translation's message
     *
     * @param uuid
     * @param message
     * @return
     */
    @Nonnull
    Translation updateMessage(@Nonnull final String uuid, @Nonnull final String message);

    /**
     * Returns a list of all translations by given ui location
     *
     * @param uiLocation ui location
     * @return translations
     */
    @Nonnull
    List<Translation> getAllByUiLocation(@Nonnull final String uiLocation);

    @Nonnull
    List<Translation> getAll();

    /**
     * Gets translations for indexation
     *
     * @param page - the page to get
     * @param size - page size
     * @return
     */
    @Nonnull
    List<Translation> getAllForIndexation(final int page, final int size);
}
