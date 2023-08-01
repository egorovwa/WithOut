package su.egorovwa.utils;

import su.egorovwa.exception.ServerDataException;

public interface DriverIdMaper {
    Long decode(String strId) throws ServerDataException;
    String encode(Long longId);
}
