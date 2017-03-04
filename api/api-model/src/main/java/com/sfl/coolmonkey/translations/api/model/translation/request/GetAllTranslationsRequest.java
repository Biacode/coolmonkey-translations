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
 * Time: 7:16 PM
 */
public class GetAllTranslationsRequest extends AbstractRequestModel {
    private static final long serialVersionUID = -5313877403498172634L;

    //region Properties
    @QueryParam("locale")
    private String locale;
    //endregion

    //region Constructors
    public GetAllTranslationsRequest() {
    }

    public GetAllTranslationsRequest(final String locale) {
        this.locale = locale;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetAllTranslationsRequest)) {
            return false;
        }
        final GetAllTranslationsRequest that = (GetAllTranslationsRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(locale, that.locale)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(locale)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("locale", locale)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getLocale() {
        return locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }
    //endregion
}
