package su.egorovwa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import su.egorovwa.dto.CarMarksFullDto;
import su.egorovwa.dto.maper.CarMarksDtoMaper;
import su.egorovwa.model.Administrator;
import su.egorovwa.service.AdministratorService;
import su.egorovwa.service.CarService;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Value("${server.address}")
    private String serverAdres;
    @Value("${server.port}")
    private String serverPort;
    private final CarService carService;
    private final CarMarksDtoMaper carMarksDtoMaper;
    private final AdministratorService administratorService;

    @GetMapping("/")
    public ModelAndView indexPage(Map<String, Object> model) {
        model.put("title", "Administrator");
        model.put("carPage", "/cars");
        model.put("description", new String("Cars hendle ".getBytes(), StandardCharsets.UTF_8));
        return new ModelAndView("index", model);
    }

    @GetMapping("/cars")
    public ModelAndView carsPage(Map<String, Object> model) {
        model.put("title", "Cars");
        return new ModelAndView("cars-page", model);
    }

    @PostMapping("/upload-cars")
    public ModelAndView uploadCars(@RequestParam("file") MultipartFile file,
                                   Map<String, Object> model) {
        carService.uploadFomCsv(file);
        model.put("title", "cars");
        return new ModelAndView("cars-page", model);
    }

    @GetMapping("/cars/models")
    public ModelAndView carModelPage(Map<String, Object> model) {
        List<CarMarksFullDto> carMarks = carService.findAll()
                .stream().map(carMarksDtoMaper::toDto)
                .toList();
        model.put("marks", carMarks);
        return new ModelAndView("ListMarksAndModelCars", model);
    }

    @PostMapping("/auth/adduser")
    public void register(Administrator administrator, BindingResult result, Model model) {
        administratorService.registreAdministrator(administrator);
    }

    @GetMapping("/auth/register")
    public String registerForm(Administrator administrator) {
        return "registrationPage";
    }

    private String serverAdress() {
        return serverAdres + ":" + serverPort;
    }
}
