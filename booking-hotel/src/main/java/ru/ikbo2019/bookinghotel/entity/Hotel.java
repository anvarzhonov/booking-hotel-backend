package ru.ikbo2019.bookinghotel.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.ikbo2019.bookinghotel.entity.enums.Rating;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * todo Document type Hotel
 */
@Entity
@Table(name = "hotels")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Hotel extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String address;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name=" chipest_price")
    private BigDecimal chipestPrice;
}
