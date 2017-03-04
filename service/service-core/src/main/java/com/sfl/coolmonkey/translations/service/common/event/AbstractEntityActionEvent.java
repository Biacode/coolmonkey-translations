package com.sfl.coolmonkey.translations.service.common.event;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.ApplicationEvent;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 2/10/16
 * Time: 5:01 PM
 */
public abstract class AbstractEntityActionEvent extends ApplicationEvent {
    private static final long serialVersionUID = -6077437244929234314L;

    //region Properties
    private final String uuid;
    //endregion

    //region Constructors
    public AbstractEntityActionEvent(final Object source, final String uuid) {
        super(source);
        this.uuid = uuid;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractEntityActionEvent)) {
            return false;
        }
        final AbstractEntityActionEvent that = (AbstractEntityActionEvent) o;
        return new EqualsBuilder()
                .append(uuid, that.uuid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(uuid)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("uuid", uuid)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getUuid() {
        return uuid;
    }
    //endregion
}
