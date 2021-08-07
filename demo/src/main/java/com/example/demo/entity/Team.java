package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "team", uniqueConstraints={@UniqueConstraint(columnNames = "name"),@UniqueConstraint(columnNames = "id")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 25)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "capitan_id", nullable = false, insertable = false, updatable = false)
    private Capitan capitan;

    @Column(name = "capitan_id", nullable = false)
    private Integer capitanId;

    @ManyToOne()
    @JoinColumn(name = "shuttle_id", nullable = false, insertable = false, updatable = false)
    private Shuttle shuttle;

    @Column(name = "shuttle_id", nullable = false)
    private Integer shuttleId;
}
