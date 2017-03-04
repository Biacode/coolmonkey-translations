package com.sfl.coolmonkey.translations.service.common.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 8:07 PM
 */
@MappedSuperclass
public abstract class AbstractDomainUuidAwareEntityModel extends AbstractDomainEntityModel {

    private static final long serialVersionUID = 4662580161116485864L;

    //region Properties
    @Column(name = "uuid", nullable = false, unique = true, length = DbConstants.UUID_COLUMN_LENGTH)
    private String uuid;
    //endregion

    //region Constructors
    public AbstractDomainUuidAwareEntityModel() {
        uuid = UUID.randomUUID().toString();
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractDomainUuidAwareEntityModel)) {
            return false;
        }
        final AbstractDomainUuidAwareEntityModel that = (AbstractDomainUuidAwareEntityModel) o;
        final EqualsBuilder builder = new EqualsBuilder();
        builder.appendSuper(super.equals(o));
        builder.append(getUuid(), that.getUuid());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.appendSuper(super.hashCode());
        builder.append(getUuid());
        return builder.build();
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);
        builder.appendSuper(super.toString());
        builder.append("uuid", getUuid());
        return builder.build();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }
    //endregion
}