package su.egorovwa.exception;

import su.egorovwa.dto.ErrorApi;

public class ServerGetvayClientException extends Exception{
    private final ErrorApi errorApi;
    private final Integer status;

    public ServerGetvayClientException(ErrorApi errorApi, Integer status) {
        this.errorApi = errorApi;
        this.status = status;
    }

    public ErrorApi getErrorApi() {
        return errorApi;
    }

    public Integer getStatus() {
        return status;
    }
}
