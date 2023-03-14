package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Collection;
import com.example.CloudFarm.enity.Product;
import com.example.CloudFarm.repository.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final StoreRepository storeRepository;

    public CollectionService(CollectionRepository collectionRepository,CustomerRepository customerRepository,
                             ProductRepository productRepository,StoreRepository storeRepository){
        this.collectionRepository = collectionRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }



    public List<Product> showProductsInCollection(int customerId) throws IllegalArgumentException{
        if(customerRepository.findById(customerId).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            List<Collection> collectionList = collectionRepository.findAllByCustomerId(customerId);
            int[] productIdArray = new int[collectionList.size()];
            for(int i = 0; i < collectionList.size(); i++ ){
                productIdArray[i] = collectionList.get(i).getProductId();
            }
            List<Product> list = new ArrayList<>();
            for(int productId : productIdArray){
                if(productRepository.findByIdAndIsDeletedFalse(productId).isEmpty()){
                    throw new IllegalArgumentException();
                }
                list.add(productRepository.findByIdAndIsDeletedFalse(productId).get());
            }
            return list;
        }
    }



    public Collection updateCollection(Collection collection) throws IllegalArgumentException{
        if(storeRepository.findById(collection.getStoreId()).isEmpty() ||
                productRepository.findById(collection.getProductId()).isEmpty() ||
                    customerRepository.findById(collection.getCustomerId()).isEmpty()) {
            throw new IllegalArgumentException();
        }else {
            Date date= new Date();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String localDate = format.format(date);
            collection.setCreateTime(localDate);
            return collectionRepository.save(collection);
        }
    }


    public void deleteCollection(int id) throws IllegalArgumentException{
        if(collectionRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            collectionRepository.deleteById(id);
        }
    }


}
