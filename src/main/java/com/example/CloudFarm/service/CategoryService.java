package com.example.CloudFarm.service;

import com.example.CloudFarm.enity.Category;
import com.example.CloudFarm.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAllByIsDeletedFalse();
    }

    public Optional<Category> findById(int id) throws IllegalArgumentException{
        if(categoryRepository.findByIdAndIsDeletedFalse(id).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            return categoryRepository.findById(id);
        }
    }

    public Category updateCategory(Category category) throws IllegalArgumentException{
        category.setDeleted(false);
        categoryRepository.save(category);
        return category;
    }

    public void deleteCategory(int id) throws IllegalArgumentException{
        Category category = categoryRepository.findByIdAndIsDeletedFalse(id).get();
        if(categoryRepository.findByIdAndIsDeletedFalse(id).isEmpty()){
            throw new IllegalArgumentException();
        }else {
            category.setDeleted(true);
            categoryRepository.save(category);
        }
    }
}
