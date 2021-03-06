package com.sudeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigserverGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigserverGitApplication.class, args);
	}
}
