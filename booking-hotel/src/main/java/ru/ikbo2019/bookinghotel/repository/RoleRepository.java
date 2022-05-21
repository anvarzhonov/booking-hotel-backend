package ru.ikbo2019.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ikbo2019.bookinghotel.security.entities.Role;
import ru.ikbo2019.bookinghotel.security.entities.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName roleUser);
}
