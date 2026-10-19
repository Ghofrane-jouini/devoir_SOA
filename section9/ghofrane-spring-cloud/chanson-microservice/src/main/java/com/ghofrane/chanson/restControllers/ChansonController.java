package com.ghofrane.chanson.restControllers;

import com.ghofrane.chanson.config.AuthorConfig;
import com.ghofrane.chanson.dto.APIResponseDto;
import com.ghofrane.chanson.service.ChansonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/api/chansons")
@RequiredArgsConstructor
public class ChansonController {

    private final ChansonService chansonService;
    private final AuthorConfig authorConfig;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getChansonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(chansonService.getChansonById(id), HttpStatus.OK);
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