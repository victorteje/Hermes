package com.example.Hermesbackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "guides")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String destination;

    @Column (nullable = false)
    private String details;

    @Column (nullable = false, unique = true)
    private String email;

    @Column
    private String photo;

}
