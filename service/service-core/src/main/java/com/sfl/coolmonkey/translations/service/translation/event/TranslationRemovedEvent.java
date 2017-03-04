package com.sfl.coolmonkey.translations.service.translation.event;

import com.sfl.coolmonkey.translations.service.common.event.AbstractEntityActionEvent;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 12:13
 */
public class TranslationRemovedEvent extends AbstractEntityActionEvent {
    private static final long serialVersionUID = -3504120672770139942L;

    //region Constructors
    public TranslationRemovedEvent(final Object source, final String uuid) {
        super(source, uuid);
    }
    //endregion
}
