package com.backend.backendjava.entities;

import com.backend.backendjava.dtos.requests.UrlRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url_tb")
public class Url implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String shortUrl;
    @Column(nullable = false)
    private LocalDate validate;

    public Url(UrlRequest request) {
        this.url = request.getUrl();
        this.validate = LocalDate.now().plusDays(2L);
    }
}
