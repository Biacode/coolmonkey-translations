package com.sfl.coolmonkey.translations.service.translation.event;

import com.sfl.coolmonkey.translations.service.common.event.AbstractEntityActionEvent;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 12:13
 */
public class TranslationModifiedEvent extends AbstractEntityActionEvent {
    private static final long serialVersionUID = 8537575114635915503L;

    //region Constructors
    public TranslationModifiedEvent(final Object source, final String uuid) {
        super(source, uuid);
    }
    //endregion
}
