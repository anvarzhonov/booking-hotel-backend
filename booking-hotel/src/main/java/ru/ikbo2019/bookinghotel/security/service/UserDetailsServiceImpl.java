package ru.ikbo2019.bookinghotel.security.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.BasicPathUsageException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ikbo2019.bookinghotel.repository.UserRepository;
import ru.ikbo2019.bookinghotel.security.entities.User;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() ->
            new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return UserPrincipal.build(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = repository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("Could not load user by id: " + id));

        return UserPrincipal.build(user);
    }
}
