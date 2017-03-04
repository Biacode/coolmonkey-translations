package com.sfl.coolmonkey.translations.service.common.model;

import org.joda.time.MutableDateTime;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 8:06 PM
 */
public abstract class AbstractBaseEntityModel implements Serializable {
    private static final long serialVersionUID = -8466097458895357978L;

    //region Static utility methods
    public static Date cloneDateIfNotNullAndStripOffMillisOfSecond(final Date date) {
        if (date == null) {
            return null;
        }
        final MutableDateTime mutableDateTime = new MutableDateTime(date);
        mutableDateTime.setMillisOfSecond(0);
        return mutableDateTime.toDate();
    }

    public static Long getIdOrNull(final AbstractDomainEntityModel entity) {
        return entity != null ? entity.getId() : null;
    }

    public static Double getDoubleValueOrNull(final BigDecimal value) {
        return value != null ? value.doubleValue() : null;
    }
    //endregion
}