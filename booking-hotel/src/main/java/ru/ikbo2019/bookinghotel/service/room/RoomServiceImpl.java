package ru.ikbo2019.bookinghotel.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ikbo2019.bookinghotel.entity.Room;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.exception.RoomException;
import ru.ikbo2019.bookinghotel.repository.RoomRepository;
import ru.ikbo2019.bookinghotel.rest.dto.RoomDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    @Override
    public List<Room> getAllRoomsByStartDateAndEndDateAndCityName(RoomDto roomDto) {
        if (Objects.isNull(roomDto) || roomDto.getCityName().isEmpty() || Objects.isNull(roomDto.getFreeDateEnd())) {
            throw new RoomException("Ошибка валидации параметров");
        }
        return repository.findAllRoomsByParams(roomDto.getFreeDateStart(), roomDto.getFreeDateEnd(), roomDto.getCityName());
    }

    @Override
    public List<Map<RoomType, Long>> getNumberOfRoomsWithRoomTypes() {
        return repository.findNumberOfRoomsWithRoomTypes();
    }
}
