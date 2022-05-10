package com.example.ecommerce_1.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "category")
public class Category {
    @Id
    @GeneratedValue
    private Long id ;

    private String name ;
}
