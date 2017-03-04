package com.sfl.coolmonkey.translations.api.model.translation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.coolmonkey.commons.api.model.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 12:22 PM
 */
public class TranslationUiLocationModel implements ApiModel {
    private static final long serialVersionUID = 5637057518551364014L;

    //region Properties
    @JsonProperty("name")
    private String name;
    //endregion

    //region Constructors
    public TranslationUiLocationModel() {
    }

    public TranslationUiLocationModel(final String name) {
        this.name = name;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TranslationUiLocationModel)) {
            return false;
        }
        final TranslationUiLocationModel that = (TranslationUiLocationModel) o;
        return new EqualsBuilder()
                .append(name, that.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //endregion
}
