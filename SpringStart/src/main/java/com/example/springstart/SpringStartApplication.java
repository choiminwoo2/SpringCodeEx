package com.example.springstart;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class SpringStartApplication {

		@Bean
		public ServletWebServerFactory servletWebServerFactory() {
				return new TomcatServletWebServerFactory();
		}

		@Bean
		public DispatcherServlet dispatcherServlet() {
				return new DispatcherServlet();
		}

		public static void main(String[] args) {
				MySpringApplication.run(SpringStartApplication.class, args);
		}



}