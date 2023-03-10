package com.example.CloudFarm.controller;

import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Category;
import com.example.CloudFarm.enity.Customer;
import com.example.CloudFarm.service.CategoryService;
import com.example.CloudFarm.service.CustomerService;
import com.example.CloudFarm.utility.ResultBuild;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    private final MessagePropertise messagePropertise;


    public CategoryController(CategoryService categoryService, MessagePropertise messagePropertise){
        this.categoryService = categoryService;
        this.messagePropertise = messagePropertise;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public ResultBuild showAllCategories(){
        ResultBuild result;
        try{

            return ResultBuild.success(categoryService.findAllCategories());
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBuild showCategoryById(@PathVariable int id){
        ResultBuild result;
        try{
            return ResultBuild.success(categoryService.findById(id));
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }

    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild updateCategories(@Validated @RequestBody Category category){
        ResultBuild result;
        try{
            return ResultBuild.success(categoryService.updateCategory(category));
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }

    @RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild deleteCategoryById(@PathVariable int id){
        ResultBuild result;
        try{
            categoryService.deleteCategory(id);
            return ResultBuild.success();
        }catch (Exception e){
            result = ResultBuild.error(this.messagePropertise.getProperties("ERROR_003"));
        }
        return result;
    }
}


