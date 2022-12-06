package hulk.softcaribbean.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private long id;
    private String dsProduct;
    private double value;
    private int stock;
    private String category;
    private String brand;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;
}
