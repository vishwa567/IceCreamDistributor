package com.icecreamdistributor.IceCream.repository;

import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProductId(Long productId);
    void deleteByProduct(Product existingProduct);
}