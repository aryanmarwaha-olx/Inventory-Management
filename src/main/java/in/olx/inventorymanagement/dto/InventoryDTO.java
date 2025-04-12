package in.olx.inventorymanagement.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InventoryDTO {
    private String sku;
    //private InventoryStatus primaryStatus;
    private String primaryLocation;
    private Double costToCompany;
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
    private String author;
    private String dealer;
    //private InventoryType type;
    private Integer yearOfPurchase;


    private String vin;
    private String make;
    private String model;
    private String trim;
    private String condition;
    private LocalDate dateOfManufacture;
}

