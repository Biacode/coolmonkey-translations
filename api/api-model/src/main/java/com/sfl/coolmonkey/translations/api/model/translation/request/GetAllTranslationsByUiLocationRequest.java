package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.QueryParam;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 4/8/16
 * Time: 4:22 PM
 */
public class GetAllTranslationsByUiLocationRequest extends AbstractRequestModel {
    private static final long serialVersionUID = 529693516612978526L;

    //region Properties
    @QueryParam("uiLocation")
    private String uiLocation;
    //endregion

    //region Constructors
    public GetAllTranslationsByUiLocationRequest() {
    }

    public GetAllTranslationsByUiLocationRequest(final String uiLocation) {
        this.uiLocation = uiLocation;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetAllTranslationsByUiLocationRequest)) {
            return false;
        }
        final GetAllTranslationsByUiLocationRequest that = (GetAllTranslationsByUiLocationRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uiLocation, that.uiLocation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uiLocation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uiLocation", uiLocation)
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
    //endregion
}
