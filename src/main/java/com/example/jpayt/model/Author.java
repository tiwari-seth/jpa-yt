package com.example.jpayt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@Table(name = "author_tbl")
public class Author {

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "author_sequence")
//    @SequenceGenerator(
//            name="author_sequence",
//            sequenceName = "auth_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.TABLE , generator = "auth_id_gen")
//    @TableGenerator(name = "auth_id_gen" ,
//                    table = "id_generator",
//                    pkColumnName = "id_name",
//                    pkColumnValue = "author_seq",
//                    valueColumnName = "id_value",
//                    allocationSize = 1,
//            initialValue = 1001
//
//                    )

//    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;
    @Column(name = "f_name")
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private int age;

    @Column(updatable = false,nullable = false)
    LocalDateTime createdAt;

    @Column(insertable = false)
    LocalDateTime lastModified;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
