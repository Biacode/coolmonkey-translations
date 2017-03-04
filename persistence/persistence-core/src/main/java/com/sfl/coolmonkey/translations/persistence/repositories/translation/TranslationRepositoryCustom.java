package com.sfl.coolmonkey.translations.persistence.repositories.translation;

import com.sfl.coolmonkey.translations.service.translation.model.Translation;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/22/16
 * Time: 3:41 PM
 */
public interface TranslationRepositoryCustom {
    List<Translation> findByLocaleAndRemovedIsNull(@Nonnull final String locale);
}
