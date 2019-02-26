package com.wjx.sjsr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wjx.sjsr.dao")
public class SjsrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjsrApplication.class, args);
	}
}
