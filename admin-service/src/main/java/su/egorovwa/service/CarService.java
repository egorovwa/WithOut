package su.egorovwa.service;

import org.springframework.web.multipart.MultipartFile;
import su.egorovwa.model.CarMark;

import java.util.List;

public interface CarService {
    public void uploadFomCsv(MultipartFile file);

    List<CarMark> findAll();
}
