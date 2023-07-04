package su.egorovwa.service.impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import su.egorovwa.model.CarMark;
import su.egorovwa.repository.CarMarklRepository;
import su.egorovwa.service.CarService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
private final CarMarklRepository carsRepository;
private final CSVParser csvParser;
    @Override
    public void uploadFomCsv(MultipartFile file) {
try (Reader reader = new InputStreamReader(file.getInputStream());
     CSVReader csvReader = new CSVReaderBuilder(reader)
             .withCSVParser(csvParser)
             .build()
){
    List<String[]> allCars = csvReader.readAll();
    List<CarMark> carMarks = allCars.stream().map(this::parseCarMark).toList();
    carsRepository.saveAll(carMarks);

} catch (IOException e) {
    throw new RuntimeException(e); // TODO: 28.06.2023 error hendle
} catch (CsvException e) {
    throw new RuntimeException(e);
}
    }

    @Override
    public List<CarMark> findAll() {
        return carsRepository.findAll();
    }

    private CarMark parseCarMark(String[] carSrting){
        String startYear = carSrting[2];
        return CarMark.builder()
                .mark(carSrting[0])
                .model(carSrting[1])
                .startYear(parseYear(carSrting[2]))
                .endYear(parseYear(carSrting[3]))
                .build();
    }
    private Integer parseYear(String strYear){
        try {
            return Integer.parseInt(strYear);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
