package ru.ikbo2019.bookinghotel.rest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ikbo2019.bookinghotel.exception.BusinessException;
import ru.ikbo2019.bookinghotel.repository.RoleRepository;
import ru.ikbo2019.bookinghotel.repository.UserRepository;
import ru.ikbo2019.bookinghotel.rest.request.LoginRequest;
import ru.ikbo2019.bookinghotel.rest.request.SignUpRequest;
import ru.ikbo2019.bookinghotel.rest.response.ApiResponse;
import ru.ikbo2019.bookinghotel.rest.response.JwtResponse;
import ru.ikbo2019.bookinghotel.security.entities.Role;
import ru.ikbo2019.bookinghotel.security.entities.RoleName;
import ru.ikbo2019.bookinghotel.security.entities.User;
import ru.ikbo2019.bookinghotel.security.jwt.JwtTokenProvider;

import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class SecurityController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken =
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtTokenProvider.generateToken(authentication);
        log.info("JWT token: {}", jwtToken);
        return ResponseEntity.ok(new JwtResponse(jwtToken));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        var username = signUpRequest.getUsername();
        if (userRepository.existsByUsername(username)) {
            return new ResponseEntity<>(
                new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        //TODO: реализовать поиск нового пользователя по email.
/*        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                HttpStatus.BAD_REQUEST);
        }*/
        // Create new user's account
        User user = new User(username,
            signUpRequest.getEmail(),
            signUpRequest.getFullName(),
            signUpRequest.getPassword());

        user.setHashPassword(passwordEncoder.encode(user.getPassword()));

        //TODO: отправить ResponseEntity<?> с кодом и сообщением ошибки об отсутствии в БД дефолтной роли
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new BusinessException("Default User Role not found in DB."));

        user.setRoles(Set.of(userRole));

        userRepository.save(user);

        log.info("Registration successfully!");

        return ResponseEntity.ok("User registered successfully!");
    }
}
