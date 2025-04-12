package in.olx.inventorymanagement.dto;
import java.time.LocalDateTime;

public class InventoryDTO {
    private String sku;
    private String type;
    //private InventoryStatus status;
    private String primaryLocation;
    private String vin;
    private String make;
    private String model;
    private String trim;
    private Integer year;
    private Double costPrice;
    private Double sellingPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}

