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
public class CreateInventoryRequest {
    private String           primaryLocation;
    private Integer          costToCompany;
    private String           middleMan;
    private String           dealer;
    private String           yearOfPurchase;

    public String            type;

    HashMap<String, String>  product = new HashMap<>();
}
