package com.starAndShadow.may.websiteReboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public void addFilm (Film film) {
        filmRepository.save(film);
    }
}