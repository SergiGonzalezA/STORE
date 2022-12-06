package hulk.softcaribbean.store.controller;


import hulk.softcaribbean.store.controller.base.ApplicationCustomException;
import hulk.softcaribbean.store.dto.ProductDto;
import hulk.softcaribbean.store.entity.Product;
import hulk.softcaribbean.store.service.ProductService;
import hulk.softcaribbean.store.util.MessagesConstants;
import hulk.softcaribbean.store.util.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductCtrl {

    private static final String ENTITY_NAME = "Product";

    private final ProductService productService;

    public ProductCtrl(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save-product")
    public ResponseEntity<ResponseMessage<Product>> save(@RequestBody Product product) throws ApplicationCustomException {
        Product response;
        try {
            response = productService.save(product);
        } catch (Exception ex) {
            throw new ApplicationCustomException(MessagesConstants.DEFAULT_ERROR_CODE, String.format(MessagesConstants.DEFAULT_ERROR_MESSAGE, ex.getMessage()));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, MessagesConstants.DEFAULT_MESSAGE_ADD, response));
    }

    @GetMapping("/list-products")
    public ResponseEntity<ResponseMessage<List<Product>>> findAll() {
        return ResponseEntity.ok(new ResponseMessage<>(0, null, productService.findAll()));
    }

    @GetMapping("/detailProduct/{id}")
    public ResponseEntity<ResponseMessage<Product>> findById(@PathVariable long id) throws ApplicationCustomException {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_NOT_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, product));
    }

}
