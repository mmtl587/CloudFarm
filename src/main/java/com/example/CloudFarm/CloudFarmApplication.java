package com.example.CloudFarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.CloudFarm.utility")
public class CloudFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFarmApplication.class, args);
	}

}
