package in.olx.inventorymanagement.controller;

import in.olx.inventorymanagement.model.dto.InventoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/")
public class InventoryManager {


    @GetMapping ("/health")
    public String health() {
        return "Hello World!!";
    }

    // Rest All Routes are to be added below:

}
