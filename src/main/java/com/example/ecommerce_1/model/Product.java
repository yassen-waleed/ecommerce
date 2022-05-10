package com.example.ecommerce_1.model;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "product")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "name",nullable = false)
    private String name ;

    @Column(name = "price",nullable = false)
    private Double price ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id ;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier_id;

}
