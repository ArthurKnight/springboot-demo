package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Spring Boot默认自动搜索启动程序之下的所有类，建议启动程序的包层次为顶级，其他类均在其下面。
 *
 * Ctrl+Alt+Shift+/ registory配置热部署
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
