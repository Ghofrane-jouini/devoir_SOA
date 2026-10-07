package com.ghofrane.genre.service;

import com.ghofrane.genre.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreByCode(String code);
}