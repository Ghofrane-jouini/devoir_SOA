package com.ghofrane.genre.restControllers;

import com.ghofrane.genre.config.AuthorConfig;
import com.ghofrane.genre.dto.GenreDto;
import com.ghofrane.genre.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private final AuthorConfig authorConfig;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{code}")
    public ResponseEntity<GenreDto> getGenreByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(genreService.getGenreByCode(code), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorConfig.getName() + " " + authorConfig.getEmail());
    }
}