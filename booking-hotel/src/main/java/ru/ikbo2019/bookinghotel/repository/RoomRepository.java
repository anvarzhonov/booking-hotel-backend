package ru.ikbo2019.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ikbo2019.bookinghotel.entity.Room;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value = "SELECT r FROM Room r " +
        "JOIN r.hotel h " +
        "JOIN h.city c " +
        "WHERE r.freeDateStart= :startDate AND r.freeDateEnd = :endDate AND c.name = :cityName")
    List<Room> findAllRoomsByParams(@Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate,
        @Param("cityName") String cityName);

    @Query(value = "SELECT r.roomType as roomType, COUNT(r) as numberOfRooms FROM Room r GROUP BY r.roomType")
    List<Map<RoomType, Long>> findNumberOfRoomsWithRoomTypes();
}
