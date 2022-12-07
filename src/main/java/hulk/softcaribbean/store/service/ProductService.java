package hulk.softcaribbean.store.service;

import hulk.softcaribbean.store.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(long id);
}
