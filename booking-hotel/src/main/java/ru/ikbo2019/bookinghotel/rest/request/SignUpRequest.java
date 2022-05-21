package ru.ikbo2019.bookinghotel.rest.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
}
