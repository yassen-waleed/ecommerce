package com.example.ecommerce_1.model;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "supplier")
public class Supplier {

    @Id
    @GeneratedValue
    private Long id ;

    @Column(name = "name",nullable = false)
    private String name ;

    @Column(name = "email",nullable = false)
    private String email ;

    @Column(name = "phone",nullable = false)
    private String phone ;

    @Column(name = "address",nullable = false)
    private String address ;
}
