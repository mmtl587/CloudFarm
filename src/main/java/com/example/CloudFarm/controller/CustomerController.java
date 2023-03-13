package com.example.CloudFarm.controller;

import com.example.CloudFarm.VO.PasswordVO;
import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Customer;
import com.example.CloudFarm.service.CustomerService;
import com.example.CloudFarm.utility.ResultBuild;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    private final MessagePropertise messagePropertise;


    public CustomerController(CustomerService customerService,MessagePropertise messagePropertise){
        this.customerService = customerService;
        this.messagePropertise = messagePropertise;
    }

    @RequestMapping(value = "/customers/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild register(@Validated @RequestBody Customer customer){
        ResultBuild result;
        try{
            customerService.customerRegister(customer);
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_002"));
        }
        return result;
    }

    @RequestMapping(value = "/customers/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild login(@Validated @RequestBody Customer customer){
        ResultBuild result;
        try{
            Map<String,Object> map = new HashMap<>();
            map = customerService.customerLogin(customer);
            return ResultBuild.success(map);
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_001"));
        }
        return result;
    }


    /**
     *  顾客修改密码
     * @param
     * @param passwordVO
     * @throws IllegalArgumentException
     */
    @RequestMapping(value = "/filter/customerPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild login(HttpServletRequest request, @Validated @RequestBody PasswordVO passwordVO){
        ResultBuild result;
        try{
            customerService.updatePassword(request.getAttribute("username").toString(), passwordVO.getNewPassword(), passwordVO.getOldPassword());
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_0010"));
        }
        return result;
    }
}
