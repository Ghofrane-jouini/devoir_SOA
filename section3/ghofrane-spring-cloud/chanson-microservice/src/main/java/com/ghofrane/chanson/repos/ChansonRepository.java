package com.ghofrane.chanson.repos;

import com.ghofrane.chanson.entities.Chanson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChansonRepository extends JpaRepository<Chanson, Long> {
}