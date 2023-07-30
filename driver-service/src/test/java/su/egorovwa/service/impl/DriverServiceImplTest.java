package su.egorovwa.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import su.egorovwa.driver.DriverServiceImpl;
import su.egorovwa.dto.DriverShortDto;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.dto.mapers.DriverDtoMaper;
import su.egorovwa.exception.ObjectAlredyExistException;
import su.egorovwa.exception.ObjectNotFoundException;
import su.egorovwa.model.Driver;
import su.egorovwa.repository.DriverRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {
    DriverServiceImpl driverService;
    @Mock
    DriverRepository driverRepository;

    @BeforeEach
    private void init() {
        driverService = new DriverServiceImpl(driverRepository, new DriverDtoMaper());
    }


    @Test
    void test1_registerDriver_when_normal() throws ObjectAlredyExistException {
        NewDriverDto newDriverDto = NewDriverDto.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .build();
        Driver driverModel = Driver.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .build();
        when(driverRepository.save(driverModel))
                .thenReturn(driverModel.toBuilder().id(1L).build());
        NewDriverDto result = driverService.registerDriver(newDriverDto);
        verify(driverRepository, times(1)).save(driverModel);
    }

    @Test
    void test2_registerDriver_when_driver_alredy_exist() throws ObjectAlredyExistException {
        NewDriverDto newDriverDto = NewDriverDto.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .build();
        Driver driverModel = Driver.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .build();
        when(driverRepository.save(driverModel))
                .thenThrow(DataIntegrityViolationException.class);
        assertThrows(ObjectAlredyExistException.class, () -> driverService.registerDriver(newDriverDto));
    }

    @Test
    void test_3_findByPhone_when_finded() throws ObjectNotFoundException {
        Driver driverModel = Driver.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .id(1L)
                .build();
        DriverShortDto newDriverDto = DriverShortDto.builder()
                .phone("+78889992121")
                .password("passsword")
                .id(1L)
                .build();
        when(driverRepository.findByPhone("+78889992121"))
                .thenReturn(Optional.of(driverModel));
        DriverShortDto result = driverService.findByPhone("+78889992121");
        verify(driverRepository, times(1)).findByPhone("+78889992121");
        assertEquals(newDriverDto, result);
    }

    @Test
    void test4_findByPhone_when_not_found() throws ObjectNotFoundException {
        when(driverRepository.findByPhone("+78889992121"))
                .thenReturn(Optional.empty());
        assertThrows(ObjectNotFoundException.class,()-> driverService.findByPhone("+78889992121"));

    }
}