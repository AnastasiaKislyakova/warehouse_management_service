package com.asasan.warehousemanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class  WarehouseManagementService {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagementService.class, args);
	}

}
