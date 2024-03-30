package com.backend.backendjava.controllers;

import com.backend.backendjava.dtos.requests.UrlRequest;
import com.backend.backendjava.dtos.responses.UrlResponse;
import com.backend.backendjava.services.UrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shorten-url")
public class UrlController {
    @Autowired
    private UrlService service;

    @PostMapping
    public ResponseEntity<UrlResponse> saveUrl(@Valid @RequestBody UrlRequest request) {
        return ResponseEntity.status(200).body(service.saveUrl(request));
    }

    @GetMapping
    public ResponseEntity<UrlResponse> getUrl(@RequestParam String url) {
        return ResponseEntity.status(200).body(service.getUrl(url));
    }
}
