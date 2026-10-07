package com.ghofrane.chanson.service;

import com.ghofrane.chanson.dto.GenreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "GENRE")
public interface APIClient {

    @GetMapping("api/genres/{genre-code}")
    GenreDto getGenreByCode(@PathVariable("genre-code") String genreCode);
}