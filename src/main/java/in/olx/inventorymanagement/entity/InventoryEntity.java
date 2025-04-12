package in.olx.inventorymanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InventoryEntity {
    @Id
    private String SKU;

}
