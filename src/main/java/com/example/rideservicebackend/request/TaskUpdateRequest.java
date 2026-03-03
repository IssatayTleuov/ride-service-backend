package com.example.rideservicebackend.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record TaskUpdateRequest(
        @NotEmpty @NotBlank
        String title,
        boolean completed
) {
}
