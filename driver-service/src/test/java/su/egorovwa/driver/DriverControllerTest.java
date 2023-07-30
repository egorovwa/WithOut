package su.egorovwa.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import su.egorovwa.dto.NewDriverDto;
import su.egorovwa.exception.ObjectAlredyExistException;

import static org.mockito.Mockito.when;


@WebMvcTest(DriverController.class)
class DriverControllerTest {
    @MockBean
    DriverService driverService;
    @Autowired
    ObjectMapper mapper;
    MockMvc mvc;

    @BeforeEach
    private void setup(WebApplicationContext context) {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
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
        NewDriverDto newDriverDtoServisReturn = NewDriverDto.builder()
                .email("Driver@mail.com")
                .fistName("Ivanov")
                .lastName("Ivan")
                .phone("+78889992121")
                .password("passsword")
                .build();
        when(driverService.registerDriver(newDriverDto))
                .thenReturn(newDriverDtoServisReturn);
        // TODO: 30.07.2023 доделать

    }


}