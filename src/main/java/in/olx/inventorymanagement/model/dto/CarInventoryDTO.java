package in.olx.inventorymanagement.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInventoryDTO {
    private String sku;

    private String primaryStatus;
    private String primaryLocation;
    private Integer costToCompany;
    private String createdAt;
    private String lastModified;
    private String middleMan;
    private String dealer;
    private String type;

    private String vin;
    private String make;
    private String model;
    private String trim;
    private String dateOfManufacture;
}

