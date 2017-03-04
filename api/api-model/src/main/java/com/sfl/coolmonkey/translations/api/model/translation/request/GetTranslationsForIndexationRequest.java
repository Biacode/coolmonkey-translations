package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.ws.rs.QueryParam;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 11:30
 */
public class GetTranslationsForIndexationRequest extends AbstractRequestModel {
    private static final long serialVersionUID = -8901078602892713157L;

    //region Properties
    @QueryParam("page")
    private int page;

    @QueryParam("size")
    private int size;
    //endregion

    //region Constructors
    public GetTranslationsForIndexationRequest() {
    }

    public GetTranslationsForIndexationRequest(final int page, final int size) {
        this.page = page;
        this.size = size;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetTranslationsForIndexationRequest)) {
            return false;
        }
        final GetTranslationsForIndexationRequest that = (GetTranslationsForIndexationRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(page, that.page)
                .append(size, that.size)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(page)
                .append(size)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("page", page)
                .append("size", size)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public int getPage() {
        return page;
    }

    public void setPage(final int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }
    //endregion
}
