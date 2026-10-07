package com.ghofrane.genre.restControllers;

import com.ghofrane.genre.dto.GenreDto;
import com.ghofrane.genre.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genres")
@AllArgsConstructor
public class GenreController {

    private GenreService genreService;

    @GetMapping("{code}")
    public ResponseEntity<GenreDto> getGenreByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(genreService.getGenreByCode(code), HttpStatus.OK);
    }
}