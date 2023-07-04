package su.egorovwa.config;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarsCsvConfig {
    @Bean
    public CSVParser csvParser() {
        return new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();
    }

}

