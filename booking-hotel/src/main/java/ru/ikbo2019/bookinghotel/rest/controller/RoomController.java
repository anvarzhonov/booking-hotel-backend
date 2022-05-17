package ru.ikbo2019.bookinghotel.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.ikbo2019.bookinghotel.entity.Room;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.rest.dto.RoomDto;
import ru.ikbo2019.bookinghotel.rest.response.FindNumberOfRoomsWithRoomTypesRs;
import ru.ikbo2019.bookinghotel.service.room.RoomService;

import java.util.List;
import java.util.Map;

/**
 * todo Document type RoomController
 */
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class RoomController {
    private final RoomService roomService;

    public List<Room> getAllRoomsWithCityNameAndDates(@RequestBody RoomDto roomDto) {
        log.info("[Getting rooms request] -> {}", roomDto);
        var response = roomService.getAllRoomsByStartDateAndEndDateAndCityName(roomDto);
        log.info("[Getting rooms response] <- {}", response);
        return response;
    }

    @GetMapping("/getNumberOfRoomsWithTypes")
    public List<Map<RoomType, Long>> getNumberOfRoomsWithRoomTypes() {
        var response = roomService.getNumberOfRoomsWithRoomTypes();
        log.info("[Getting number of rooms with types response] <- {}", response);
        return response;
    }
}
