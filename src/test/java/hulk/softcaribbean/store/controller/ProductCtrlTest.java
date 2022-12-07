package hulk.softcaribbean.store.controller;

import hulk.softcaribbean.store.controller.base.ApplicationCustomException;
import hulk.softcaribbean.store.entity.Product;
import hulk.softcaribbean.store.entity.Rol;
import hulk.softcaribbean.store.service.ProductService;
import hulk.softcaribbean.store.util.MessagesConstants;
import hulk.softcaribbean.store.util.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductCtrlTest {

    @InjectMocks
    ProductCtrl productCtrl;
    @Mock
    ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() throws ApplicationCustomException {
        Product product = new Product();
        product.setCategory("juguete");
        when(productService.save(product)).thenReturn(product);

        ResponseEntity<ResponseMessage<Product>> responde = productCtrl.save(product);
        assertNotNull(responde);
        assertEquals(responde.getBody().getData(),product);
    }

    @Test
    void findAll() throws ApplicationCustomException{
        List<Product> products = new ArrayList<>();
        when(productService.findAll()).thenReturn(products);
        ResponseEntity<ResponseMessage<List<Product>>> responde = productCtrl.findAll();
        assertNotNull(responde);
        assertEquals(responde.getBody().getData(),products);
    }

    @Test
    void findById() throws ApplicationCustomException{
        Product product = new Product();
        when(productService.findById(1L)).thenReturn(product);
        ResponseEntity<ResponseMessage<Product>> responde = productCtrl.findById(1L);
        assertNotNull(responde);
        assertEquals(responde.getBody().getData(),product);
    }
    @Test
    void findByIdError() {
        Product product = null;
        when(productService.findById(1L)).thenReturn(product);
        try{
            productCtrl.findById(1);
        }catch (ApplicationCustomException e){
            assertEquals(e.getMessage(),"No existe Product con ese id");
        }

    }
}
