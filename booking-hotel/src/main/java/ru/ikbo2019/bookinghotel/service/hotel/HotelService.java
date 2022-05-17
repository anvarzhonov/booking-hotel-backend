package ru.ikbo2019.bookinghotel.service.hotel;

import ru.ikbo2019.bookinghotel.entity.Hotel;
import ru.ikbo2019.bookinghotel.rest.dto.HotelDto;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    List<Hotel> getAllByCityName(String name);

    List<HotelDto> getAllCountHotelsInCities();

    /**
     * Получить список всех отелей, цена номеров в которых находится в промежутке
     * @param minPrice - минимальная сумма номера
     * @param maxPrice - максимальная сумма номера
     * @return список отелей
     */
    List<Hotel> getHotelsByRoomPriceBetween(Long minPrice, Long maxPrice);
}
