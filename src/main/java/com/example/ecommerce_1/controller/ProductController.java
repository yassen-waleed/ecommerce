package com.example.ecommerce_1.controller;

import com.example.ecommerce_1.Service.ProductServices;
import com.example.ecommerce_1.dto.ProductDTO;
import com.example.ecommerce_1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/product")
@RestController

public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productServices.getAllProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getproductById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(productServices.getProductById(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productServices.getProductByCategoryId(id));
    }

    @GetMapping("/supplier/{id}")
    public ResponseEntity<List<Product>> getProductBySupplierId(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productServices.getProductBySupplierId(id));
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return productServices.addProduct(productDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO
            , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(productServices.updateProduct(productDTO, id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long id) {
        productServices.deleteProductById(id);
        return new ResponseEntity<>("product has been Deleted successfully.", HttpStatus.OK);
    }
}
