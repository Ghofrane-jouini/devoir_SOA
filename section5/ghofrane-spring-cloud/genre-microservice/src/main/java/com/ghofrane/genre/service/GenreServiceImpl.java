package com.ghofrane.genre.service;

import com.ghofrane.genre.dto.GenreDto;
import com.ghofrane.genre.entities.Genre;
import com.ghofrane.genre.repos.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Override
    public GenreDto getGenreByCode(String code) {
        Genre g = genreRepository.findByCode(code);
        return new GenreDto(g.getId(), g.getNom(), g.getCode());
    }
}