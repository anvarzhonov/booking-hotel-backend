package ru.ikbo2019.bookinghotel.service.room;

import ru.ikbo2019.bookinghotel.entity.Room;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.rest.dto.RoomDto;
import ru.ikbo2019.bookinghotel.rest.response.FindNumberOfRoomsWithRoomTypesRs;

import java.util.List;
import java.util.Map;

public interface RoomService {

    /**
     * Получить список всех номеров по названию города и датами въезда/ отъезда
     * @return список номеров
     */
    List<Room> getAllRoomsByStartDateAndEndDateAndCityName(RoomDto roomDto);

    /**
     * Получить название и количество типов номеров
     * @return название и количество типов номеров
     */
    List<Map<RoomType, Long>> getNumberOfRoomsWithRoomTypes();
}
