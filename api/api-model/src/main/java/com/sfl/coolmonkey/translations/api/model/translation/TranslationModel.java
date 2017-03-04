package com.sfl.coolmonkey.translations.api.model.translation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 7:08 PM
 */
public class TranslationModel implements ApiModel {
    private static final long serialVersionUID = -1318269560271163328L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("uiLocation")
    private String uiLocation;

    @JsonProperty("key")
    private String key;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("message")
    private String message;
    //endregion

    //region Constructors
    public TranslationModel() {
    }

    public TranslationModel(final String uuid,
                            final String uiLocation,
                            final String key,
                            final String locale,
                            final String message) {
        this.uuid = uuid;
        this.uiLocation = uiLocation;
        this.key = key;
        this.locale = locale;
        this.message = message;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TranslationModel)) {
            return false;
        }
        final TranslationModel that = (TranslationModel) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .append(uiLocation, that.uiLocation)
                .append(key, that.key)
                .append(locale, that.locale)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .append(uiLocation)
                .append(key)
                .append(locale)
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("uiLocation", uiLocation)
                .append("key", key)
                .append("locale", locale)
                .append("message", message)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

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
