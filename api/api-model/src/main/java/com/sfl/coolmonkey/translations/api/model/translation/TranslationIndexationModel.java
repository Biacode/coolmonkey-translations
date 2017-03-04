package com.sfl.coolmonkey.translations.api.model.translation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 11:28
 */
public class TranslationIndexationModel implements ApiModel {
    private static final long serialVersionUID = -2143833710675171015L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("uiLocation")
    private String uiLocation;

    @JsonProperty("key")
    private String key;

    @JsonProperty("message")
    private String message;

    @JsonProperty("created")
    private Date created;
    //endregion

    //region Constructors
    public TranslationIndexationModel() {
    }

    public TranslationIndexationModel(final String uuid,
                                      final String locale,
                                      final String uiLocation,
                                      final String key,
                                      final String message,
                                      final Date created) {
        this.uuid = uuid;
        this.locale = locale;
        this.uiLocation = uiLocation;
        this.key = key;
        this.message = message;
        this.created = created;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TranslationIndexationModel)) {
            return false;
        }
        final TranslationIndexationModel that = (TranslationIndexationModel) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .append(locale, that.locale)
                .append(uiLocation, that.uiLocation)
                .append(key, that.key)
                .append(message, that.message)
                .append(created, that.created)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .append(locale)
                .append(uiLocation)
                .append(key)
                .append(message)
                .append(created)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .append("locale", locale)
                .append("uiLocation", uiLocation)
                .append("key", key)
                .append("message", message)
                .append("created", created)
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }
    //endregion
}
