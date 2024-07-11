package com.kalpit00.Springdata.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, // lazy does not fetch the parent course! EAGER does
            optional = true
    )
    @JoinColumn( // now course material has an extra column which species its "course_id" from another entity!
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
