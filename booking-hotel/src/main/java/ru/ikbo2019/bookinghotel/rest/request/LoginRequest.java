package ru.ikbo2019.bookinghotel.rest.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
