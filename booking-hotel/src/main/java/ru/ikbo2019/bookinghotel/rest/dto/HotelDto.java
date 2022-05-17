package ru.ikbo2019.bookinghotel.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * todo Document type HotelDto
 */
@Data
@AllArgsConstructor
public class HotelDto {
    private String cityName;
    private Long numberOfCities;
}
