package com.example.CloudFarm.controller;

import com.example.CloudFarm.config.MessagePropertise;
import com.example.CloudFarm.enity.Carousel;
import com.example.CloudFarm.repository.CarouselRepository;
import com.example.CloudFarm.service.CarouselService;
import com.example.CloudFarm.service.CustomerService;
import com.example.CloudFarm.utility.ResultBuild;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class CarouselController {
    private final CarouselService carouselService;

    private final CarouselRepository carouselRepository;
    private final MessagePropertise messagePropertise;


    public CarouselController(CarouselService carouselService,MessagePropertise messagePropertise,CarouselRepository carouselRepository){
        this.carouselService = carouselService;
        this.messagePropertise = messagePropertise;
        this.carouselRepository = carouselRepository;
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultBuild uploadImage(@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return ResultBuild.error("文件为空");
        }

        try {
            //获取文件的字节数组
            byte[] bytes = file.getBytes();
            //构建文件保存的路径
            String path = "src/main/resources/static/asset/";
            //获取文件名
            String filename = file.getOriginalFilename();
            //创建文件路径
            File filePath = new File(path + filename);
            //将文件保存到本地文件系统中
            Files.write(filePath.toPath(), bytes);

            Carousel carousel = new Carousel();
            carousel.setImage(filePath.getCanonicalPath());
            carouselRepository.save(carousel);
            // return success result
            return ResultBuild.success("文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            // return error result
            return ResultBuild.error("文件上传失败");
        }
    }


}
