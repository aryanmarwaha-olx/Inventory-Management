package in.olx.inventorymanagement.Interfaces;

import java.time.LocalDate;

public interface Product {
    String getVin();
    String getMake();
    String getModel();
    String getTrim();
    String getCondition();
    LocalDate getDateOfManufacture();
}
