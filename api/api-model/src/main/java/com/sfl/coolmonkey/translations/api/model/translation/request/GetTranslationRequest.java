package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.QueryParam;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 8:22 PM
 */
public class GetTranslationRequest extends AbstractRequestModel {
    private static final long serialVersionUID = -450071023144094395L;

    //region Properties
    @QueryParam("uiLocation")
    private String uiLocation;

    @QueryParam("key")
    private String key;

    @QueryParam("locale")
    private String locale;
    //endregion

    //region Constructors
    public GetTranslationRequest() {
    }

    public GetTranslationRequest(final String uiLocation, final String key, final String locale) {
        this.uiLocation = uiLocation;
        this.key = key;
        this.locale = locale;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetTranslationRequest)) {
            return false;
        }
        final GetTranslationRequest that = (GetTranslationRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uiLocation, that.uiLocation)
                .append(key, that.key)
                .append(locale, that.locale)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uiLocation)
                .append(key)
                .append(locale)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("uiLocation", uiLocation)
                .append("key", key)
                .append("locale", locale)
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
    //endregion
}
