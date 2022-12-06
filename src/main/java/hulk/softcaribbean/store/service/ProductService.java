package hulk.softcaribbean.store.service;

import hulk.softcaribbean.store.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);
    List<Product> findAll();

    Optional<Product> findById(long id);
}
