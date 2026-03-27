package com.refaccionaria.auth.model;

public record LoginResponse(String tokenType, String accessToken, long expiresInSeconds) {
}
