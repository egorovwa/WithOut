package su.egorovwa.service;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import su.egorovwa.client.Client;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.ServerGetvayClientException;
import su.egorovwa.security.DriverDetails;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService, UserDetailsService {
    private final Client client;
    private final BCryptPasswordEncoder encoder;

    @Override
    public NewDriverDto registre(NewDriverDto newDriverDto) throws ServletException, IOException, ServerGetvayClientException {

        return client.registerDriver(newDriverDto.toBuilder()
                .password(encoder.encode(Base64.getEncoder().encodeToString(newDriverDto.password().getBytes())))
                .build());
    }

    @Override
    public Optional<DriverShortDto> findByPhone(String name) {
        return client.findDriverByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.findByPhone(username)
                .map(it -> DriverDetails.builder()
                        .password(it.password())
                        .phone(it.phone())
                        .isAccountNonExpired(true)
                        .isCredentialsNonExpired(true)
                        .isEnabled(true)
                        .isLocked(false)
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Driver not found"));
    }
}
