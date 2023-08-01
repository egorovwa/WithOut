package su.egorovwa.dto.mapers;

import org.springframework.stereotype.Component;
import su.egorovwa.dto.location.AdressDto;
import su.egorovwa.model.Address;

@Component
public class AddresDtoMaper {
    AdressDto toDto(Address address){
        return new AdressDto(address.getId(),address.getCity(),address.getStreet(), address.getNumber());
    }
}
