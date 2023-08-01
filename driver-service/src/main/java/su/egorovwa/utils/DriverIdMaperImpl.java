package su.egorovwa.utils;

import org.springframework.stereotype.Component;
import su.egorovwa.exception.ServerDataException;
@Component
public class DriverIdMaperImpl implements DriverIdMaper {
    @Override
    public Long decode(String strId) throws ServerDataException {

        try {
            return Long.parseLong(strId);
        }catch (NumberFormatException e){
            throw  new ServerDataException("Driver id not valid");
        }
    }

    @Override
    public String encode(Long longId) {
        return longId.toString();
    }
}
