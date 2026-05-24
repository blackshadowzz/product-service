package com.mango.productservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "title")
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    @Column(name = "deleted",nullable = false)
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
