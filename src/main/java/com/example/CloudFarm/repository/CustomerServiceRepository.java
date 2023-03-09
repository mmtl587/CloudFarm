package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Customer;
import com.example.CloudFarm.enity.CustomerService;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, Integer>, JpaSpecificationExecutor<CustomerService> {
}
