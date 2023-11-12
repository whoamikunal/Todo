package com.demo.todo.dao;

import com.demo.todo.enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.*;
import org.hibernate.validator.constraints.*;

import java.time.*;
import java.util.*;

@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@ToString
public class Task extends AbstractEntity {
    @Column(name = "title", nullable = false)
    @Length(min = 2, max = 256)
    private String title;

    @Column(name = "description")
    @Length(max = 512)
    private String description;

    @Column(name = "due_date")
    private Instant dueDate;

    @Column(name = "completed", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean completed;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
