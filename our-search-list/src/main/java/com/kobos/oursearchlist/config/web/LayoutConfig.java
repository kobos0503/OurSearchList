package com.kobos.oursearchlist.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class LayoutConfig {
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
