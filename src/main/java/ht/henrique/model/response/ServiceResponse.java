package ht.henrique.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse {
    private String responseCode;
    private String responseMessage;
    private Response response;

    public ServiceResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public ServiceResponse(String responseCode, String responseMessage, Response response) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.response = response;
    }
}
