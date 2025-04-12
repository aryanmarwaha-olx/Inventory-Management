package in.olx.inventorymanagement.Product;

import java.time.LocalDate;

public interface Product {
    String getVin();
    String getMake();
    String getModel();
    String getTrim();
    String getCondition();
    LocalDate getDateOfManufacture();
}
