package com.ghofrane.chanson.service;

import com.ghofrane.chanson.dto.APIResponseDto;

public interface ChansonService {
    APIResponseDto getChansonById(Long id);
}