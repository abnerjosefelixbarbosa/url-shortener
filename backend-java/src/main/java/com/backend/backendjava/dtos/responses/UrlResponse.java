package com.backend.backendjava.dtos.responses;

import com.backend.backendjava.entities.Url;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrlResponse {
    private Long id;
    private String url;
    private String shortUrl;
    private LocalDate validate;

    public UrlResponse(Url url) {
        this.id = url.getId();
        this.url = url.getUrl();
        this.shortUrl = url.getShortUrl();
        this.validate = url.getValidate();
    }
}
