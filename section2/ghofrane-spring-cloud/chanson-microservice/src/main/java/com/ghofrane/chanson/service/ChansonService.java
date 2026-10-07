package com.ghofrane.chanson.service;

import com.ghofrane.chanson.dto.ChansonDto;

public interface ChansonService {
    ChansonDto getChansonById(Long id);
}