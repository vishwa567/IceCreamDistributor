package com.icecreamdistributor.IceCream.repository;

import com.icecreamdistributor.IceCream.entity.Sale;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @EntityGraph(attributePaths = {"saleItems"})
    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.saleDate = :date")
    Double sumBySaleDate(@Param("date") LocalDate date);

    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.saleDate BETWEEN :start AND :end")
    Double sumBySaleDateBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);


    List<Sale> findBySaleDate(LocalDate date);

    List<Sale> findBySaleDateBetween(LocalDate start, LocalDate end);

}