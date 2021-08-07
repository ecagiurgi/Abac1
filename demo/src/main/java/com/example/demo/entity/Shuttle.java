package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "shuttle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shuttle {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String name;
}
