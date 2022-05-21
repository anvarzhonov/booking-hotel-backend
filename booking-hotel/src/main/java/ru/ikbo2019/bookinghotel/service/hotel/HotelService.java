package ru.ikbo2019.bookinghotel.service.hotel;

import ru.ikbo2019.bookinghotel.entity.Hotel;
import ru.ikbo2019.bookinghotel.rest.dto.HotelDto;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();

    /**
     * Получить информацию об отеле по его ID
     * @param id - уникальный идентификатор отеля
     * @return подробности об отеле
     */
    Hotel getById(Integer id);

    /**
     * Получить список всех отелей по названию города
     * @param name - название города
     * @return количество подходящих отелей
     */
    List<Hotel> getAllByCityName(String name);

    /**
     * Получить количество отелей в во всех городах
     * @return список с названием города и количеством имеющихся отелей в нем
     */
    List<HotelDto> getAllCountHotelsInCities();

    /**
     * Получить список всех отелей, цена номеров в которых находится в промежутке
     * @param minPrice - минимальная сумма номера
     * @param maxPrice - максимальная сумма номера
     * @return список отелей
     */
    List<Hotel> getHotelsByRoomPriceBetween(String cityName, Long minPrice, Long maxPrice);
}
