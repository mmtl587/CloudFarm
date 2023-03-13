package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Farmer;
import com.example.CloudFarm.enity.Farmer;
import com.example.CloudFarm.repository.FarmerRepository;
import com.example.CloudFarm.utility.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FarmerService {
    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository){
        this.farmerRepository = farmerRepository;
    }


    /**
     * 农户注册
     * @param farmer
     * @throws IllegalArgumentException
     */
    public void farmerRegister(Farmer farmer)throws IllegalArgumentException{
        if(farmerRepository.findByUsername(farmer.getUsername()).isPresent()){
            throw new IllegalArgumentException();
        }else {
            farmerRepository.save(farmer);
        }
    }


    /**
     * 农户登录
     * @param farmer
     * @return
     * @throws IllegalArgumentException
     */
    public Map<String,Object> farmerLogin(Farmer farmer)throws IllegalArgumentException{
        Optional<Farmer> farmer1 = farmerRepository.findByUsername(farmer.getUsername());
        Map<String,Object> map = new HashMap<>();
        if(farmer1.isPresent() && (farmer1.get().getPassword().equals(farmer.getPassword()))){
            farmer1.get().setPassword(null);
            String token = JwtUtil.createFarmerToken(farmer1.get());
            map.put("token" ,token);
        }else {
            throw new IllegalArgumentException();
        }
        return map;
    }


    public void updatePassword(String username,String newPassword,String oldPassword) throws IllegalArgumentException{
        Farmer farmer = farmerRepository.findByUsername(username).get();
        if(farmerRepository.findByUsername(username).isPresent() && farmer.getPassword().equals(oldPassword)){
            farmer.setPassword(newPassword);
            farmerRepository.save(farmer);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
