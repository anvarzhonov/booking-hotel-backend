package ru.ikbo2019.bookinghotel.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * todo Document type City
 */
@Entity
@Table(name = "cities")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class City extends BaseEntity{

    private String name;
}
