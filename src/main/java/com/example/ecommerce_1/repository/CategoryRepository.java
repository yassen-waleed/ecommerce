package com.example.ecommerce_1.repository;

import com.example.ecommerce_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
