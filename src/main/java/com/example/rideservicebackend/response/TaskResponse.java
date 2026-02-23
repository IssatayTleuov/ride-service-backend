package com.example.rideservicebackend.response;

public record TaskResponse(
        Long id,
        String title,
        boolean completed
) {
}
