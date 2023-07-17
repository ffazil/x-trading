package com.example.x.trading.jpa.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author firoz
 */

@MappedSuperclass
public class AbstractAggregateRoot implements Persistable<UUID>, Serializable {

    @CreatedDate
    @Column(columnDefinition = "timestamp")
    protected LocalDateTime created = LocalDateTime.now();
    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    public UUID id;
    @Version
    @JsonIgnore
    private Long version;
    @JsonIgnore
    @Column(name = "is_active")
    protected boolean isActive = true;
    @Transient
    private boolean isNew = true;
    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp")
    private LocalDateTime modified;

    @LastModifiedBy
    private String lastModifiedBy;

    protected AbstractAggregateRoot(UUID givenId) {
        this.id = givenId != null ? givenId : UUID.randomUUID();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Override
    @JsonIgnore
    public boolean isNew() {
        return isNew;
    }

    /**
     * Marks the entity as not new not make sure we merge entity instances instead of trying to persist them.
     */
    @PostPersist
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }

        AbstractAggregateRoot that = (AbstractAggregateRoot) obj;

        return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
    }

    protected Boolean terminate() {
        if (this.isActive) {
            this.isActive = false;
        }
        return isActive;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public Long getVersion() {
        return this.version;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getModified() {
        return this.modified;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public String toString() {
        return "AbstractAggregateRoot(id=" + this.getId() + ")";
    }

    public UUID getId() {
        return this.id;
    }

    public boolean isActive() {
        return this.isActive;
    }
}
