package su.egorovwa.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import su.egorovwa.model.Administrator;
import su.egorovwa.repository.AdministratotRepository;
import su.egorovwa.service.AdministratorService;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratotRepository administratotRepository;
private final BCryptPasswordEncoder encoder;
    @Override
    public void registreAdministrator(Administrator administrator) {
        administrator.setIsEnabled(true);
        log.info("registred admin {}", administrator);
        administrator.toBuilder()
                        .password(encoder.encode(administrator.getPassword()))
                .build();
        administratotRepository.save(administrator);
    }
}
