package com.lahat.springmodulith;

import org.springframework.boot.SpringApplication;

public class TestSpringModulithApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringModulithApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
