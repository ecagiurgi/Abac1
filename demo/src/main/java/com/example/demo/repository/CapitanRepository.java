package com.example.demo.repository;

import com.example.demo.entity.Capitan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitanRepository extends JpaRepository<Capitan, Integer> {
    Capitan findByUsername(String username);
}
