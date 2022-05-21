package ru.ikbo2019.bookinghotel.security.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.ikbo2019.bookinghotel.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private RoleName name;
}
