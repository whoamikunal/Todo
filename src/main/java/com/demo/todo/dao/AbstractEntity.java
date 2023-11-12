package com.demo.todo.dao;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.support.*;

import java.io.*;
import java.time.*;
import java.util.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder(toBuilder = true)
@ToString
public abstract class AbstractEntity implements Persistable<Long>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Transient
    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity that)) return false;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(createdAt, that.createdAt)) return false;
        return Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCreatedAt(), getUpdatedAt());
    }
}
