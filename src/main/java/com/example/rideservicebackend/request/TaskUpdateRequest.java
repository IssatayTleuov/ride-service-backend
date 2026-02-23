package com.example.rideservicebackend.request;

public record TaskUpdateRequest(
        String title,
        boolean completed
) {
}
