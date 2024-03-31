package com.jp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class SprinbootRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinbootRestapiApplication.class, args);
	}

}
