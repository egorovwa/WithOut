package su.egorovwa.dto.mapers;

import org.springframework.stereotype.Component;
import su.egorovwa.dto.LocationDto;
import su.egorovwa.model.Location;
@Component
public class LocationDtoMaper {
   public LocationDto toDto(Location location){
       return LocationDto.builder()
               .lat(location.getLat())
               .lon(location.getLon())
               .build();
   }
}
