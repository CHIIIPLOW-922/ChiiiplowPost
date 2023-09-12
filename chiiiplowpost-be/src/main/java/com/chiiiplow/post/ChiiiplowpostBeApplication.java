package com.chiiiplow.post;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author CHIIIPLOW
 * @date 2023/09/10
 */
@SpringBootApplication(scanBasePackages = "com.chiiiplow.post")
@MapperScan(basePackages = "com.chiiiplow.post.mapper")
@EnableTransactionManagement
public class ChiiiplowpostBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChiiiplowpostBeApplication.class, args);
	}

}
