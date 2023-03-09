package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Farmer;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer>, JpaSpecificationExecutor<Farmer> {
    public Optional<Farmer> findByUsername(String username);
}
