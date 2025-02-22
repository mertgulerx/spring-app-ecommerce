package com.mertg.cinemia.security.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    @Size(min = 3)
    private String username;

    @NotBlank
    private String password;

}
