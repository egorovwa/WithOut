package su.egorovwa.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import su.egorovwa.exception.UnauthorizedExeption;
import su.egorovwa.model.Administrator;
import su.egorovwa.repository.AdministratotRepository;
@Service
@RequiredArgsConstructor
public class AdminDetailService implements UserDetailsService {
    private final AdministratotRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = repository.findByName(username)
                .orElseThrow(()->new UnauthorizedExeption("Admin not found"));
                return new AdminUserDetails()
                        .toBuilder()
                        .userName(administrator.getName())
                        .password(administrator.getPassword())
                        .isEnabled(administrator.getIsEnabled())
                        .build();
    }
}
