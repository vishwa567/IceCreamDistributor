package com.icecreamdistributor.IceCream.repository;

import com.icecreamdistributor.IceCream.entity.Product;
import com.icecreamdistributor.IceCream.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
    List<SaleItem> findAllBySaleId(Long saleId);
    void deleteAllByProduct(Product existingProduct);
}