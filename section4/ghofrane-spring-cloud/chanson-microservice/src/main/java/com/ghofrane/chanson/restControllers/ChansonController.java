package com.ghofrane.chanson.restControllers;

import com.ghofrane.chanson.dto.APIResponseDto;
import com.ghofrane.chanson.service.ChansonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chansons")
@AllArgsConstructor
public class ChansonController {

    private ChansonService chansonService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getChansonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(chansonService.getChansonById(id), HttpStatus.OK);
    }
}