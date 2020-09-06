package com.fgs.fgscashbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fgs.fgscashbook.mapper")
@SpringBootApplication
public class FgscashbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FgscashbookApplication.class, args);
	}

}
