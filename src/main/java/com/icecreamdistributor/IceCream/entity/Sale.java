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
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Double totalAmount = 0.0;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate saleDate;

    @OneToMany(mappedBy = "sale")
    private Set<SaleItem> saleItems = new HashSet<>();
}
