package ru.ikbo2019.bookinghotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.entity.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * todo Document type Room
 */
@Entity
@Table(name="rooms")
@Getter
@Setter
@RequiredArgsConstructor
public class Room extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "number_of_rooms")
    private int numberRooms;

    @Column(name = "free_date_start")
    private LocalDate freeDateStart;

    @Column(name = "free_date_end")
    private LocalDate freeDateEnd;


}
