package su.egorovwa.dto.maper;

import org.springframework.stereotype.Component;
import su.egorovwa.dto.CarMarksFullDto;
import su.egorovwa.model.CarMark;
@Component
public class CarMarksDtoMaper {
   public CarMarksFullDto toDto(CarMark carMark){

      return CarMarksFullDto.builder()
              .id(carMark.getId())
              .mark(carMark.getMark())
              .model(carMark.getModel())
              .startYear(getYear(carMark.getStartYear()))
              .endYear(getYear(carMark.getEndYear()))
              .build();
   }
   private String getYear(Integer year){
      if (year!=null){
         return year.toString();
      }else return "-";
   }
}
