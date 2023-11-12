package com.demo.todo.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import org.hibernate.validator.constraints.*;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode(callSuper = true)
public class Topic extends AbstractEntity {
    @Column(name = "name", nullable = false)
    @Length(min = 4, max = 256)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "topic_id")
    private Set<Task> tasks;
}
