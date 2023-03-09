package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Carousel;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarouselRepository extends JpaRepository<Carousel, Integer>, JpaSpecificationExecutor<Carousel> {
}
