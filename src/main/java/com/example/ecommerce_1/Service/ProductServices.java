package com.example.ecommerce_1.Service;

import com.example.ecommerce_1.dto.ProductDTO;
import com.example.ecommerce_1.exceptions.ResourceNotFoundException;
import com.example.ecommerce_1.model.Category;
import com.example.ecommerce_1.model.Product;
import com.example.ecommerce_1.repository.CategoryRepository;
import com.example.ecommerce_1.repository.ProductRepository;
import com.example.ecommerce_1.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    public ProductRepository productRepository ;
    @Autowired
    private CategoryRepository categoryRepository ;
    @Autowired
    private SupplierRepository supplierRepository ;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public ProductDTO getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));
        return mapToDTO(product);

    }

    public List<Product> getProductByCategoryId(Long id) {
        return productRepository.findByCategoryId(id) ;
    }

    public List<Product> getProductBySupplierId(Long id) {
        return productRepository.findBySupplier_id(id) ;
    }

    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {

        Product product = mapToEntity(productDTO);
        Product newProduct = productRepository.save(product);
        ProductDTO productResponse = mapToDTO(newProduct);
        return new ResponseEntity<ProductDTO>(productResponse, HttpStatus.OK);


    }


    public ProductDTO updateProduct(ProductDTO productDto, long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("product", "id", id);
        });

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory_id(categoryRepository.getById(productDto.getCategory_id()));
        product.setSupplier_id(supplierRepository.getById(productDto.getSupplier_id()));

        Product updatedProduct = productRepository.save(product);
        return mapToDTO(updatedProduct);
    }


    public void deleteProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", "id", id));
        productRepository.delete(product);
    }


    // convert Entity into DTO
    private ProductDTO mapToDTO(Product product){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategory_id(product.getCategory_id().getId());
        productDto.setSupplier_id(product.getSupplier_id().getId());
        return productDto;
    }

    // convert DTO to entity
    private Product mapToEntity(ProductDTO productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory_id(categoryRepository.getById(productDto.getCategory_id()));
        product.setSupplier_id(supplierRepository.getById(productDto.getSupplier_id()));
        return product;
    }


}
