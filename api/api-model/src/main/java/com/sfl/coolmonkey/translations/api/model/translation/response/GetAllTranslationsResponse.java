package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 7:16 PM
 */
public class GetAllTranslationsResponse extends AbstractResponseModel {
    private static final long serialVersionUID = -7531274634297184114L;

    //region Properties
    @JsonProperty("map")
    private Map<String, Map<String, String>> map;
    //endregion

    //region Constructors
    public GetAllTranslationsResponse() {
    }

    public GetAllTranslationsResponse(final Map<String, Map<String, String>> map) {
        this.map = map;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetAllTranslationsResponse)) {
            return false;
        }
        final GetAllTranslationsResponse that = (GetAllTranslationsResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(map, that.map)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(map)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("map", map)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public Map<String, Map<String, String>> getMap() {
        return map;
    }

    public void setMap(final Map<String, Map<String, String>> map) {
        this.map = map;
    }
    //endregion
}
