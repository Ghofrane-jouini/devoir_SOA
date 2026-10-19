package com.ghofrane.genre.repos;

import com.ghofrane.genre.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByCode(String code);
}