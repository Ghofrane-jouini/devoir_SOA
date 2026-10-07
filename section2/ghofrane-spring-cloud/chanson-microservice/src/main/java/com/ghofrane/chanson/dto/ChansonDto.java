package com.ghofrane.chanson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChansonDto {
    private Long id;
    private String titre;
    private String artiste;
    private String genreCode;
}