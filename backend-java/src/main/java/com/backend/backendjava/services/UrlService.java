package com.backend.backendjava.services;

import com.backend.backendjava.dtos.requests.UrlRequest;
import com.backend.backendjava.dtos.responses.UrlResponse;
import com.backend.backendjava.entities.Url;
import com.backend.backendjava.repositories.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public UrlResponse saveUrl(UrlRequest request) {
        String shortUrl = getUrlShot();

        if (repository.existsByUrl(request.getUrl())) {
            throw new RuntimeException("url exists");
        }

        Url url = new Url(request);
        url.setShortUrl("https://xxx.com/" + shortUrl);
        return new UrlResponse(repository.save(url));
    }

    public UrlResponse getUrl(String url) {
        Url urlFound = repository.findByUrl(url).orElseThrow(() -> {
            throw  new EntityNotFoundException("url not found");
        });
        return new UrlResponse(urlFound);
    }

    private String getUrlShot() {
        Random random = new Random();
        final int MIN = 5;
        final int MAX = 10;
        int length = MIN + random.nextInt(MAX - MIN + 1);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return stringBuilder.toString();
    }
}
