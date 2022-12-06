package hulk.softcaribbean.store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TH_PRODUCTS", schema = "hulk")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dsProduct;
    private double value;
    private int stock;
    private String category;
    private String brand;
    private LocalDate dateCreated;
    private LocalDate dateUpdated;

}
