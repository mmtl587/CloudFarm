package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Store;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>, JpaSpecificationExecutor<Store> {

    public void deleteById(int id);



    public Optional<Store> findByIdAndIsDeletedFalse(int id);

    public List<Store> findAllByIsDeletedFalse();
}
