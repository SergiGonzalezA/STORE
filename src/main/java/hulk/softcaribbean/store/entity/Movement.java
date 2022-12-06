package hulk.softcaribbean.store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TH_MOVEMENTS", schema = "hulk")
public class Movement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User idUser;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product.class)
    private Product idProduct;
    private LocalDateTime dateCreated;
    @Column(nullable = false)
    private int quantity;
    private String type;
}
