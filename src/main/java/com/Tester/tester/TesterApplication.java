package com.Tester.tester;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Tester.tester.dao")
public class TesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesterApplication.class, args);
	}

}

