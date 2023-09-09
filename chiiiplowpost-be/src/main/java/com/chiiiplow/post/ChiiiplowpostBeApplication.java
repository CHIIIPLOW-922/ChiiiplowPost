package com.chiiiplow.post;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.chiiiplow.post")
@MapperScan("com.chiiiplow.post.mapper")
public class ChiiiplowpostBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChiiiplowpostBeApplication.class, args);
	}

}
