package com.example.ecommerce_1.repository;

import com.example.ecommerce_1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "select * from Product p  where p.category_id = ?1 ",nativeQuery = true)
    List<Product> findByCategoryId (Long CategoryId);

    @Query(value = "select * from Product p  where p.supplier_id = ?1 ",nativeQuery = true)
    List<Product> findBySupplier_id (Long supplier_id);

}
