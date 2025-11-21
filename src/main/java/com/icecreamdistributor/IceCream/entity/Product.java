package com.icecreamdistributor.IceCream.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double purchasePrice;

    @Column(nullable = false)
    private Double sellingPrice;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @OneToMany(mappedBy = "product")
    private Set<Purchase> purchases = new HashSet<>();

    @OneToOne(mappedBy = "product")
    private Stock stock;

    @OneToMany(mappedBy = "product")
    private Set<SaleItem> saleItems = new HashSet<>();
}
