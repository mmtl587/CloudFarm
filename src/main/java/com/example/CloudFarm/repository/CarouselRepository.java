package com.example.CloudFarm.repository;

import com.example.CloudFarm.enity.Carousel;
import com.example.CloudFarm.enity.StoreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarouselRepository extends JpaRepository<Carousel, Integer>, JpaSpecificationExecutor<Carousel> {
    public List<Carousel> findAllByTargetType(int targetType);

    public Optional<Carousel> findById(int id);

    public void deleteById(int id);
}
