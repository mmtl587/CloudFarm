package com.example.CloudFarm.controller;

import com.example.CloudFarm.VO.PasswordVO;
import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Farmer;
import com.example.CloudFarm.service.FarmerService;
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
public class FarmerController {
    private final FarmerService farmerService;

    private final MessagePropertise messagePropertise;

    public FarmerController(FarmerService farmerService,MessagePropertise messagePropertise){
        this.farmerService = farmerService;
        this.messagePropertise = messagePropertise;
    }


    @RequestMapping(value = "/farmers/register", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild register(@Validated @RequestBody Farmer farmer){
        ResultBuild result;
        try{
            farmerService.farmerRegister(farmer);
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_002"));
        }
        return result;
    }

    @RequestMapping(value = "/farmers/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild login(@Validated @RequestBody Farmer farmer){
        ResultBuild result;
        try{
            Map<String,Object> map = new HashMap<>();
            map = farmerService.farmerLogin(farmer);
            return ResultBuild.success(map);
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_001"));
        }
        return result;
    }


    @RequestMapping(value = "/filter/farmerPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild login(HttpServletRequest request, @Validated @RequestBody PasswordVO passwordVO) {
        ResultBuild result;
        try {
            farmerService.updatePassword(request.getAttribute("username").toString(), passwordVO.getNewPassword(), passwordVO.getOldPassword());
            return ResultBuild.success();
        } catch (Exception e) {
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_0010"));
        }
        return result;
    }
}
