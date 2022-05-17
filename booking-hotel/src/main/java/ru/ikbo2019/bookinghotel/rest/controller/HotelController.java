package ru.ikbo2019.bookinghotel.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.ikbo2019.bookinghotel.entity.Hotel;
import ru.ikbo2019.bookinghotel.rest.dto.HotelDto;
import ru.ikbo2019.bookinghotel.service.hotel.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping()
    public List<Hotel> getHotelsByCityName(@RequestParam("city") String destination){
        log.info("[get all hotels by city name] -> city name: {}", destination);
        var response = hotelService.getAllByCityName(destination);
        log.info("[get hotels info response] <- {}", response);
        return response;
    }

    @GetMapping("/countByCity")
    public List<HotelDto> getAllCountHotelsInCities(){
        log.info("[get all count hotels in cities] ->");
        var response = hotelService.getAllCountHotelsInCities();
        log.info("[get hotels info response] <- {}", response);
        return response;
    }

    @GetMapping("/findHotelsByPriceBetween")
    public List<Hotel> getHotelsByRoomPriceBetween(@RequestParam("min") Long minPrice, @RequestParam("max") Long maxPrice){
        log.info("[get hotels by room price between] -> minPrice: {}, maxPrice: {}", minPrice, maxPrice);
        var response = hotelService.getHotelsByRoomPriceBetween(minPrice, maxPrice);
        log.info("[get hotels by room price between] <- {}", response);
        return response;
    }
}
