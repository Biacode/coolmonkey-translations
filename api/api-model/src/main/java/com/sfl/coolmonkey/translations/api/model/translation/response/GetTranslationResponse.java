package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 8:23 PM
 */
public class GetTranslationResponse extends AbstractResponseModel {
    private static final long serialVersionUID = 6961014802272749376L;

    //region Properties
    @JsonProperty("message")
    private String message;
    //endregion

    //region Constructors
    public GetTranslationResponse() {
    }

    public GetTranslationResponse(final String message) {
        this.message = message;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetTranslationResponse)) {
            return false;
        }
        final GetTranslationResponse that = (GetTranslationResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("message", message)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
    //endregion
}
