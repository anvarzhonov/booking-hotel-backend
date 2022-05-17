package ru.ikbo2019.bookinghotel.service.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ikbo2019.bookinghotel.entity.Hotel;
import ru.ikbo2019.bookinghotel.repository.HotelRepository;
import ru.ikbo2019.bookinghotel.rest.dto.HotelDto;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repository;

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public List<Hotel> getAllByCityName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public List<HotelDto> getAllCountHotelsInCities() {
        return repository.findAllCountHotelsInCities();
    }

    @Override
    public List<Hotel> getHotelsByRoomPriceBetween(Long minPrice, Long maxPrice) {
        return repository.findByChipestPriceBetween(BigDecimal.valueOf(minPrice), BigDecimal.valueOf(maxPrice));
    }
}