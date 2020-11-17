package com.tju.bianyuan.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BianyuanProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(BianyuanProductApplication.class, args);
	}

}
