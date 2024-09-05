package ht.henrique.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import ht.henrique.model.database.Charge;
import ht.henrique.model.database.Seller;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChargesResponse implements Response {
    private List<Charge> charges;
    private String chargeValue;
    private String chargeCode;

    public ChargesResponse(List<Charge> charges) {
        this.charges = charges;
    }
}
