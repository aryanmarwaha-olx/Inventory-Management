package in.olx.inventorymanagement.model.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateInventoryRequest {

    public String          type;
    public String          sku;
    public String          productId;
    public String          primaryStatus;
    public String          productType;
    public Integer         costToCompany;
    public String          primaryLocation;                                             // create warehouse.
    public String          updateDate;
    public String          createDate;
    public String          dealer;
    public String          middleMan;

    HashMap<String, String> product = new HashMap<>();
}
