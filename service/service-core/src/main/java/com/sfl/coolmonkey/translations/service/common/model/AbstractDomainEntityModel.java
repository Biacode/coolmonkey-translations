package com.sfl.coolmonkey.translations.service.common.model;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 8:07 PM
 */
@MappedSuperclass
public abstract class AbstractDomainEntityModel extends AbstractBaseEntityModel {
    private static final long serialVersionUID = -1755949194480994048L;

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "removed", nullable = true)
    private Date removed;

    @Column(name = "updated", nullable = false)
    private Date updated;
    //endregion

    //region Constructors
    public AbstractDomainEntityModel() {
        final Date currentDate = new Date();
        created = currentDate;
        updated = currentDate;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractDomainEntityModel)) {
            return false;
        }
        final AbstractDomainEntityModel that = (AbstractDomainEntityModel) o;
        final EqualsBuilder builder = new EqualsBuilder();
        builder.append(getId(), that.getId());
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getId());
        return builder.build();
    }

    @Override
    public String toString() {
        final ToStringBuilder builder = new ToStringBuilder(this);
        builder.append("id", getId());
        builder.append("created", getCreated());
        builder.append("removed", getRemoved());
        builder.append("updated", getUpdated());
        return builder.build();
    }
    //endregion

    //region Properties getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return ObjectUtils.clone(created);
    }

    public void setCreated(Date created) {
        this.created = ObjectUtils.clone(created);
    }

    public Date getRemoved() {
        return ObjectUtils.clone(removed);
    }

    public void setRemoved(Date removed) {
        this.removed = ObjectUtils.clone(removed);
    }

    public Date getUpdated() {
        return ObjectUtils.clone(updated);
    }

    public void setUpdated(Date updated) {
        this.updated = ObjectUtils.clone(updated);
    }
    //endregion
}