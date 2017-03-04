package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 6:48 PM
 */
public class UpdateTranslationMessageRequest extends AbstractRequestModel {
    private static final long serialVersionUID = -6266236619541936155L;

    //region Properties
    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("message")
    private String message;
    //endregion

    //region Constructors
    public UpdateTranslationMessageRequest() {
    }

    public UpdateTranslationMessageRequest(final String uuid, final String message) {
        this.uuid = uuid;
        this.message = message;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateTranslationMessageRequest)) {
            return false;
        }
        final UpdateTranslationMessageRequest that = (UpdateTranslationMessageRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(uuid, that.uuid)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(uuid)
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
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

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
    //endregion
}
