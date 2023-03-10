package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Category;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    public Optional<Category> findByIdAndIsDeletedFalse(int id);

    public List<Category> findAllByIsDeletedFalse();

    public void deleteById(int id);
}
