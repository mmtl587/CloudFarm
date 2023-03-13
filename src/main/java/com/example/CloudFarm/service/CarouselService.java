package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Carousel;
import com.example.CloudFarm.enity.Category;
import com.example.CloudFarm.repository.CarouselRepository;
import org.springframework.stereotype.Service;

@Service
public class CarouselService {
    private final CarouselRepository carouselRepository;


    public CarouselService(CarouselRepository carouselRepository){
        this.carouselRepository = carouselRepository;
    }


    public void deleteCarouseInfo(int id) throws IllegalArgumentException{
        Carousel carousel = carouselRepository.findById(id).get();
        if(carouselRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            carouselRepository.deleteById(id);
        }
    }

}
