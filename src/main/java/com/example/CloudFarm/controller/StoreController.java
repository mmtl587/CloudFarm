package com.example.CloudFarm.controller;

import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Category;
import com.example.CloudFarm.enity.Store;
import com.example.CloudFarm.service.StoreService;
import com.example.CloudFarm.utility.ResultBuild;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class StoreController {
    private final StoreService storeService;

    private final MessagePropertise messagePropertise;


    public StoreController(StoreService storeService, MessagePropertise messagePropertise){
        this.storeService = storeService;
        this.messagePropertise = messagePropertise;
    }

    @RequestMapping(value = "/store/findAllStores", method = RequestMethod.GET)
    @ResponseBody
    public ResultBuild findAllStores(){
        ResultBuild result;
        try{
            return ResultBuild.success(storeService.showAllStore());
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }


    @RequestMapping(value = "/store/updateStore", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild updateStore(@Validated @RequestBody Store store){
        ResultBuild result;
        try{
            return ResultBuild.success(storeService.updateStore(store));
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }

    @RequestMapping(value = "/store/deleteStore/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild deleteStoreInfo(@PathVariable int id){
        ResultBuild result;
        try{
            storeService.deleteStore(id);
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }
}
