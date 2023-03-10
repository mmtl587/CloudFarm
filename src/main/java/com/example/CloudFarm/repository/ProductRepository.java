package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Product;
import com.example.CloudFarm.enity.ProductTag;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    public Optional<Product> findByIdAndIsDeletedFalse(int id);
}
