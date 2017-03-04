package com.sfl.coolmonkey.translations.service.translation.listener;

import com.sfl.coolmonkey.translations.service.translation.event.TranslationModifiedEvent;
import com.sfl.coolmonkey.translations.service.translation.event.TranslationRemovedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 12:14
 */
public interface TranslationEventListener {
    @EventListener
    void handleTranslationModifiedEvent(@Nonnull final TranslationModifiedEvent event);

    @EventListener
    void handleTranslationRemovedEvent(@Nonnull final TranslationRemovedEvent event);
}
