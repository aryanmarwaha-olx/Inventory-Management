package in.olx.inventorymanagement.model.dto.ResponseDTO;

import in.olx.inventorymanagement.model.enums.ProductType;
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
    public String                   skuId;
    public String                   primaryStatus;
    public String                   primaryLocation;
    public Integer                  costToCompany;
    public String                   lastModified;
    public String                   middleMan;
    public String                   dealer;
    public String                   yearOfPurchase;

    public String                   type;

    public HashMap<String, String>  product;

    public InventoryDTO(String skuId,
                        String primaryStatus,
                        String primaryLocation,
                        String lastModified,
                        String middleMan,
                        String dealer,
                        Integer costToCompany,
                        String yearOfPurchase,
                        String type) {

        this.skuId = skuId;
        this.primaryStatus = primaryStatus;
        this.primaryLocation = primaryLocation;
        this.costToCompany = costToCompany;
        this.lastModified = lastModified;
        this.middleMan = middleMan;
        this.dealer = dealer;
        this.yearOfPurchase = yearOfPurchase;
        this.type = type;
        this.product = new HashMap<>();
    }

    public InventoryDTO(String skuId,
                        String primaryStatus,
                        String primaryLocation,
                        String lastModified,
                        String middleMan,
                        String dealer,
                        Integer costToCompany,
                        String yearOfPurchase,
                        String type,
                        HashMap<String, String> product) {

        this.skuId = skuId;
        this.primaryStatus = primaryStatus;
        this.primaryLocation = primaryLocation;
        this.costToCompany = costToCompany;
        this.lastModified = lastModified;
        this.middleMan = middleMan;
        this.dealer = dealer;
        this.yearOfPurchase = yearOfPurchase;
        this.type = type;
        this.product = product;
    }
}