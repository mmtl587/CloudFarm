package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.ProductComment;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer>, JpaSpecificationExecutor<ProductComment> {
}
