package com.example.ecommerce_1.repository;

import com.example.ecommerce_1.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
