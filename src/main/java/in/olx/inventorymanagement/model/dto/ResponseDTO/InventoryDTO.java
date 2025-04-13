package in.olx.inventorymanagement.model.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private String           sku;
    private String           primaryStatus;
    private String           primaryLocation;
    private Integer          costToCompany;
    private LocalDate        lastModified;
    private String           middleMan;
    private String           dealer;
    private String           yearOfPurchase;

    public String            type;

    HashMap<String, String>  product              = new HashMap<>();
}