package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Collection;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer>, JpaSpecificationExecutor<Collection> {
    public List<Collection> findAllByCustomerId(int customerId);

    public void deleteById(int id);
}
