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

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
//    public InventoryStatus getPrimaryStatus() {
//        return primaryStatus;
//    }
//    public void setPrimaryStatus(InventoryStatus primaryStatus) {
//        this.primaryStatus = primaryStatus;
//    }
    public String getPrimaryLocation() {
        return primaryLocation;
    }
    public void setPrimaryLocation(String primaryLocation) {
        this.primaryLocation = primaryLocation;
    }
    public Double getCostToCompany() {
        return costToCompany;
    }
    public void setCostToCompany(Double costToCompany) {
        this.costToCompany = costToCompany;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getLastModified() {
        return lastModified;
    }
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDealer() {
        return dealer;
    }
    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
//    public InventoryType getType() {
//        return type;
//    }
//    public void setType(InventoryType type) {
//        this.type = type;
//    }
    public Integer getYearOfPurchase() {
        return yearOfPurchase;
    }
    public void setYearOfPurchase(Integer yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }
    public String getVin() {
        return vin;
    }
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getTrim() {
        return trim;
    }
    public void setTrim(String trim) {
        this.trim = trim;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }
    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}

