package com.sudeep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.metadata.JmxAttributeSource;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterRegistration;

import java.io.File;

@SuppressWarnings("deprecation")
@SpringBootApplication(exclude = { JacksonAutoConfiguration.class,JmxAutoConfiguration.class, WebSocketMessagingAutoConfiguration.class, WebSocketServletAutoConfiguration.class })
public class SpringBootGifAppApplication {

	@Value("${multipart.location}/gif/")
	private String gifLocation;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGifAppApplication.class, args);
	}

	@PostConstruct
	private void init() {
		File gifFolder = new File(gifLocation);
		if (!gifFolder.exists()) {
			gifFolder.mkdir();
		}
	}

	//deregistating not required beans from application
	
//	@Bean
//	public FilterRegistration dereg(HiddenHttpMethodFilter filter) {
//		
//		@SuppressWarnings("rawtypes")
//		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
//		
//		bean.setEnabled(false);
//		return (FilterRegistration) bean;
//	}
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/gif/**").addResourceLocations("file:" + gifLocation);
				super.addResourceHandlers(registry);
			}
		};
	}
}
