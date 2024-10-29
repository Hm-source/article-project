package com.example.articleproject.repository;

import com.example.articleproject.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findById(Long userId);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}

