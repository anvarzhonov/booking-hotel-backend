package ru.ikbo2019.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ikbo2019.bookinghotel.entity.Hotel;
import ru.ikbo2019.bookinghotel.rest.dto.HotelDto;

import java.math.BigDecimal;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query(value="select h FROM Hotel h JOIN h.city c WHERE c.name =:name")
    List<Hotel> findAllByName(String name);

    @Query(value= "select new ru.ikbo2019.bookinghotel.rest.dto.HotelDto(c.name, COUNT(c.name)) FROM Hotel h JOIN h.city c GROUP BY c.name")
    List<HotelDto> findAllCountHotelsInCities();

//    @Query(value="select h FROM Hotel h WHERE h.chipestPrice BETWEEN (:min, :max)")
    List<Hotel> findByCityNameAndChipestPriceBetween(String cityName, BigDecimal min, BigDecimal max);
}
