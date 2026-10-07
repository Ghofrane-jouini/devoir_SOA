package com.ghofrane.chanson.service;

import com.ghofrane.chanson.dto.ChansonDto;
import com.ghofrane.chanson.entities.Chanson;
import com.ghofrane.chanson.repos.ChansonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChansonServiceImpl implements ChansonService {

    private ChansonRepository chansonRepository;

    @Override
    public ChansonDto getChansonById(Long id) {
        Chanson c = chansonRepository.findById(id).get();
        return new ChansonDto(c.getId(), c.getTitre(), c.getArtiste(), c.getGenreCode());
    }
}