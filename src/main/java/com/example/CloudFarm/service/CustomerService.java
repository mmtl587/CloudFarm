package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Customer;
import com.example.CloudFarm.repository.CustomerRepository;
import com.example.CloudFarm.utility.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /**
     * 顾客注册
     * @param customer
     * @throws IllegalArgumentException
     */
    public void customerRegister(Customer customer) throws IllegalArgumentException{
        if(customerRepository.findByUsername(customer.getUsername()).isPresent()){
            throw new IllegalArgumentException();
        }else {
            customerRepository.save(customer);
        }
    }

    /**
     * 顾客登陆
     * @param customer
     * @return
     * @throws IllegalArgumentException
     */
    public Map<String,Object> customerLogin(Customer customer) throws IllegalArgumentException{
        Optional<Customer> customer1 = customerRepository.findByUsername(customer.getUsername());
        Map<String,Object> map = new HashMap<>();
        if(customer1.isPresent() && (customer1.get().getPassword().equals(customer.getPassword()))){
            customer1.get().setPassword(null);
            String token = JwtUtil.createCustomerToken(customer1.get());
            map.put("token" ,token);
        }else {
            throw new IllegalArgumentException();
        }
        return map;
    }


    /**
     *  顾客修改密码
     * @param
     * @param newPassword
     * @param oldPassword
     * @throws IllegalArgumentException
     */
    public void updatePassword(String username,String newPassword,String oldPassword) throws IllegalArgumentException{
        Customer customer = customerRepository.findByUsername(username).get();
        if(customerRepository.findByUsername(username).isPresent() && customer.getPassword().equals(oldPassword)){
            customer.setPassword(newPassword);
            customerRepository.save(customer);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
