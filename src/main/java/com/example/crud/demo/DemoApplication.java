package com.example.crud.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(value="com.example.crud.demo.mapper")
@SpringBootApplication(scanBasePackages = {"com.example.crud.demo"})
@ComponentScan({"com.example.crud.demo"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
