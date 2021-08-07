package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Blob;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "planet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column()
    private String description;

    @Column()
    private String image;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(10) default 'TODO'")
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "team_id", nullable = false, insertable = false, updatable = false)
    private Team team;

    @Column(name = "team_id", nullable = false)
    private Integer teamId;
}
