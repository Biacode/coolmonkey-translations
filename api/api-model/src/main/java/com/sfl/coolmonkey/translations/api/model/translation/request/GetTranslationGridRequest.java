package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractCompanyUuidAwareRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.QueryParam;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 2:34 PM
 */
public class GetTranslationGridRequest extends AbstractCompanyUuidAwareRequestModel {
    private static final long serialVersionUID = -3943544497179284048L;

    //region Properties
    @QueryParam("locale")
    private String locale;

    @QueryParam("uiLocation")
    private String uiLocation;
    //endregion

    //region Constructors
    public GetTranslationGridRequest() {
    }

    public GetTranslationGridRequest(final String companyUuid, final String locale, final String uiLocation) {
        super(companyUuid);
        this.locale = locale;
        this.uiLocation = uiLocation;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetTranslationGridRequest)) {
            return false;
        }
        final GetTranslationGridRequest that = (GetTranslationGridRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(locale, that.locale)
                .append(uiLocation, that.uiLocation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(locale)
                .append(uiLocation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("locale", locale)
                .append("uiLocation", uiLocation)
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

    public String getUiLocation() {
        return uiLocation;
    }

    public void setUiLocation(final String uiLocation) {
        this.uiLocation = uiLocation;
    }
    //endregion
}
