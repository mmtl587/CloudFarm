package com.example.CloudFarm.controller;

import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Collection;
import com.example.CloudFarm.service.CollectionService;
import com.example.CloudFarm.utility.ResultBuild;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class CollectionController {
    private final CollectionService collectionService;

    private final MessagePropertise messagePropertise;


    public CollectionController(CollectionService collectionService, MessagePropertise messagePropertise){
        this.collectionService = collectionService;
        this.messagePropertise = messagePropertise;
    }



    @RequestMapping(value = "/filter/findAllCollections", method = RequestMethod.GET)
    @ResponseBody
    public ResultBuild findAllCollections(HttpServletRequest request){
        ResultBuild result;
        try{
            return ResultBuild.success(collectionService.showProductsInCollection(Integer.parseInt(request.getAttribute("id").toString())));
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }
    
    
    @RequestMapping(value = "/collection/updateCollection", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild updateCollection(@Validated @RequestBody Collection collection){
        ResultBuild result;
        try{
            return ResultBuild.success(collectionService.updateCollection(collection));
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }

    @RequestMapping(value = "/collection/deleteCollection/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild deleteCollectionInfo(@PathVariable int id){
        ResultBuild result;
        try{
            collectionService.deleteCollection(id);
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }
}
