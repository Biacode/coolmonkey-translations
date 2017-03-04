package com.sfl.coolmonkey.translations.service.translation.model;

import com.sfl.coolmonkey.translations.service.common.model.AbstractDomainUuidAwareEntityModel;
import com.sfl.coolmonkey.translations.service.common.model.DbConstants;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 5:31 PM
 */
@Entity(name = "translation")
@Table(name = "translation",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"locale", "ui_location", "message_key"})
        },
        indexes = @Index(columnList = "uuid", unique = true)
)
public class Translation extends AbstractDomainUuidAwareEntityModel {
    private static final long serialVersionUID = -5181563479077860537L;

    //region Properties
    @Column(name = "locale", nullable = false)
    private String locale;

    @Column(name = "ui_location", nullable = false)
    private String uiLocation;

    // Do not rename this column to "key". Doing so will fail because that word is mysql keyword.
    @Column(name = "message_key", nullable = false)
    private String key;

    @Column(name = "message", nullable = false, length = DbConstants.STRING_COLUMN_DEFAULT_LENGTH)
    private String message;
    //endregion

    //region Constructors
    public Translation() {
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Translation)) {
            return false;
        }
        final Translation that = (Translation) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uiLocation, that.uiLocation)
                .append(key, that.key)
                .append(locale, that.locale)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uiLocation)
                .append(key)
                .append(locale)
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("uiLocation", uiLocation)
                .append("key", key)
                .append("locale", locale)
                .append("message", message)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUiLocation() {
        return uiLocation;
    }

    public void setUiLocation(final String uiLocation) {
        this.uiLocation = uiLocation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
    //endregion
}
