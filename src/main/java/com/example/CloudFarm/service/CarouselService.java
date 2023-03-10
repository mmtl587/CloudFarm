package com.example.CloudFarm.service;

import com.example.CloudFarm.repository.CarouselRepository;
import org.springframework.stereotype.Service;

@Service
public class CarouselService {
    private final CarouselRepository carouselRepository;


    public CarouselService(CarouselRepository carouselRepository){
        this.carouselRepository = carouselRepository;
    }


}
