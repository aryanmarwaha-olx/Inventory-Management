package in.olx.inventorymanagement.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Table(name = "locations")
@Component
public class LocationEntity {
    @Id
    private Long     lId;
    private String   address;
    private String   city;
    private String   state;
    private String   zip;
    private String   country;
    private String   phone;
    private String   email;
}
