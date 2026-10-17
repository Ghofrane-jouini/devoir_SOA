package com.ghofrane.chanson.service;

import com.ghofrane.chanson.dto.APIResponseDto;
import com.ghofrane.chanson.dto.ChansonDto;
import com.ghofrane.chanson.dto.GenreDto;
import com.ghofrane.chanson.entities.Chanson;
import com.ghofrane.chanson.repos.ChansonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChansonServiceImpl implements ChansonService {

    private ChansonRepository chansonRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getChansonById(Long id) {
        Chanson chanson = chansonRepository.findById(id).get();

        GenreDto genreDto = apiClient.getGenreByCode(chanson.getGenreCode());

        ChansonDto chansonDto = new ChansonDto(
                chanson.getId(),
                chanson.getTitre(),
                chanson.getArtiste(),
                chanson.getGenreCode(),
                genreDto.getNom()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setChansonDto(chansonDto);
        apiResponseDto.setGenreDto(genreDto);

        return apiResponseDto;
    }
}