package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "capitan", uniqueConstraints={@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "id")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Capitan {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String username;

    @Column(nullable = false, length = 25)
    private String password;

    @Column(nullable = false, length = 25)
    private String name;
}
