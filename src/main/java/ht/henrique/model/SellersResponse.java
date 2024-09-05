package ht.henrique.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import ht.henrique.model.database.Seller;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellersResponse implements Response {
    private List<Seller> sellers;
    private String sellerName;
    private String sellerCode;

    public SellersResponse(List<Seller> sellers) {
        this.sellers = sellers;
    }
}
