package com.sfl.coolmonkey.translations.persistence.repositories.translation.impl;

import com.sfl.coolmonkey.translations.persistence.repositories.translation.TranslationRepositoryCustom;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import org.hibernate.jpa.QueryHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/22/16
 * Time: 3:42 PM
 */
@Component
public class TranslationRepositoryImpl implements TranslationRepositoryCustom {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationRepositoryImpl.class);

    //region Constants
    private static final String BY_LOCALE_AND_NOT_REMOVED_HQL = "from com.sfl.coolmonkey.translations.service.translation.model.Translation as tr where tr.locale=:locale and removed is null";

    private static final int HINT_FETCH_SIZE = 2500;
    //endregion

    //region Dependencies
    @PersistenceContext
    private EntityManager entityManager;
    //endregion

    //region Constructors
    public TranslationRepositoryImpl() {
        LOGGER.debug("Initializing");
    }
    //endregion

    //region Public methods
    @Override
    public List<Translation> findByLocaleAndRemovedIsNull(@Nonnull final String locale) {
        return entityManager
                .createQuery(BY_LOCALE_AND_NOT_REMOVED_HQL)
                .setParameter("locale", locale)
                .setHint(QueryHints.HINT_FETCH_SIZE, HINT_FETCH_SIZE)
                .getResultList();
    }
    //endregion
}
