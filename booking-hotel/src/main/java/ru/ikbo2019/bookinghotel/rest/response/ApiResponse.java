package ru.ikbo2019.bookinghotel.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccess;
    private String message;


}
