package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "robot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Robot {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "team_id", insertable = false, updatable = false)
    private Team team;

//    @Column(name = "team_id")
//    private Team teamId;
}
