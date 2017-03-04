package com.sfl.coolmonkey.translations.persistence.repositories.translation;

import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Babken Vardanyan
 * <p>
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 5:53 PM
 */
@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long>, TranslationRepositoryCustom {

    Translation findByUuid(@Nonnull final String uuid);

    List<Translation> findByLocaleAndUiLocationAndRemovedIsNull(@Nonnull final String locale, @Nonnull final String uiLocation);

    List<Translation> findByUiLocation(@Nonnull final String uiLocation);

    Translation findByUiLocationAndKeyAndLocaleAndRemovedIsNull(@Nonnull final String uiLocation, @Nonnull final String key, @Nonnull final String locale);

    @Query("select distinct uiLocation from translation")
    List<String> findAllUiLocations();

    Page<Translation> findByRemovedIsNull(@Nonnull final Pageable pageable);
}
