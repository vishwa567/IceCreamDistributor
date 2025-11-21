package com.icecreamdistributor.IceCream.repository;

import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    void deleteAllByProduct(Product existingProduct);
}