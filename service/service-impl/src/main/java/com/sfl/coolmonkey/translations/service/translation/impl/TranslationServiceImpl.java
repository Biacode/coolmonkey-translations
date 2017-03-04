package com.sfl.coolmonkey.translations.service.translation.impl;

import com.sfl.coolmonkey.translations.persistence.repositories.translation.TranslationRepository;
import com.sfl.coolmonkey.translations.service.common.exception.ServicesRuntimeException;
import com.sfl.coolmonkey.translations.service.translation.TranslationService;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 5:51 PM
 */
@Service
public class TranslationServiceImpl implements TranslationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationServiceImpl.class);

    //region Dependencies
    @Autowired
    private TranslationRepository translationRepository;
    //endregion

    //region Constructors
    public TranslationServiceImpl() {
        LOGGER.debug("Initializing translation service");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public Translation getById(@Nonnull final Long id) {
        Assert.notNull(id);
        final Translation translation = translationRepository.findOne(id);
        assertTranslationNotNullForId(id, translation);
        return translation;
    }

    @Nonnull
    @Override
    public Translation getByUuid(@Nonnull final String uuid) {
        Assert.hasText(uuid);
        final Translation translation = translationRepository.findByUuid(uuid);
        assertTranslationNotNullForUuid(uuid, translation);
        return translation;
    }

    @Nonnull
    @Override
    public List<Translation> getAllByLocale(@Nonnull final String locale) {
        Assert.notNull(locale);
        return translationRepository.findByLocaleAndRemovedIsNull(locale);
    }

    @Nonnull
    @Override
    public List<Translation> getAllByLocaleAndUiLocation(@Nonnull final String locale, @Nonnull final String uiLocation) {
        Assert.notNull(locale);
        Assert.notNull(uiLocation);
        return translationRepository.findByLocaleAndUiLocationAndRemovedIsNull(locale, uiLocation);
    }

    @Nonnull
    @Override
    public Translation getByUiLocationKeyLocale(@Nonnull final String uiLocation, @Nonnull final String key, @Nonnull final String locale) {
        Assert.notNull(uiLocation);
        Assert.notNull(key);
        Assert.notNull(locale);
        final Translation translation = translationRepository.findByUiLocationAndKeyAndLocaleAndRemovedIsNull(uiLocation, key, locale);
        if (translation == null) {
            LOGGER.error("Could not find translation by given ui location - {}, key - {} and locale - {}", uiLocation, key, locale);
            throw new ServicesRuntimeException("Could not find translation by given ui location, key and locale");
        }
        return translation;
    }

    @Nonnull
    @Override
    public List<String> getAllUiLocations() {
        return translationRepository.findAllUiLocations();
    }

    @Transactional
    @Nonnull
    @Override
    public Translation updateMessage(@Nonnull final String uuid, @Nonnull final String message) {
        Assert.notNull(uuid);
        Assert.notNull(message);
        final Translation translation = getByUuid(uuid);
        translation.setMessage(message);
        translation.setUpdated(new Date());
        return translationRepository.save(translation);
    }

    @Nonnull
    @Override
    public List<Translation> getAllByUiLocation(@Nonnull final String uiLocation) {
        Assert.notNull(uiLocation);
        return translationRepository.findByUiLocation(uiLocation);
    }

    @Nonnull
    @Override
    public List<Translation> getAll() {
        return translationRepository.findAll();
    }

    @Nonnull
    @Override
    public List<Translation> getAllForIndexation(final int page, final int size) {
        Assert.isTrue(page >= 0);
        Assert.isTrue(size > 0);
        final Page<Translation> translations = translationRepository.findByRemovedIsNull(new PageRequest(page, size, Sort.Direction.ASC, "created"));
        return translations.getContent();
    }
    //endregion

    //region Utility methods
    private void assertTranslationNotNullForId(final Long id, final Translation translation) {
        if (translation == null) {
            LOGGER.error("Translation not found for id - {}", id);
            throw new ServicesRuntimeException("Translation not found for provided id");
        }
    }

    private void assertTranslationNotNullForUuid(final String uuid, final Translation translation) {
        if (translation == null) {
            LOGGER.error("Translation not found for uuid - {}", uuid);
            throw new ServicesRuntimeException("Translation not found for provided uuid");
        }
    }
    //endregion
}
