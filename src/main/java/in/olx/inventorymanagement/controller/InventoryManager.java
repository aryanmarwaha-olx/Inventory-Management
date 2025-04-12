package in.olx.inventorymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/")
public class InventoryManager {

    @GetMapping ("/health")
    public String health() {
        return "Hello World!!";
    }

    // Rest All Routes are to be added below:

}
