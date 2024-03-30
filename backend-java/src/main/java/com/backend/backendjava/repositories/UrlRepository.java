package com.backend.backendjava.repositories;

import com.backend.backendjava.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, String> {
    boolean existsByUrl(String url);
    Optional<Url> findByUrl(String url);
}