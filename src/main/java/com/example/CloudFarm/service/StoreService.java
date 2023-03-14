package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Store;
import com.example.CloudFarm.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }


    public List<Store> showAllStore(){
        return storeRepository.findAllByIsDeletedFalse();
    }

    public Store updateStore(Store store) throws IllegalArgumentException{
        storeRepository.save(store);
        return store;
    }

    public void deleteStore(int id) throws IllegalArgumentException{
        Store store = storeRepository.findByIdAndIsDeletedFalse(id).get();
        if(storeRepository.findByIdAndIsDeletedFalse(id).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            store.setDeleted(true);
            storeRepository.save(store);
        }
    }


}
