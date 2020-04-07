package com.wjx.sjsr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@MapperScan("com.wjx.sjsr.dao.*")
@EntityScan(basePackages={"com.wjx.sjsr.entity.*"})
public class SjsrApplication {
	public static void main(String[] args) {
		SpringApplication.run(SjsrApplication.class, args);
	}
}
