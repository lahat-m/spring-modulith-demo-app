package com.lahat.spring_modulith;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class SpringModulithApplicationTests {

	@Test
	void contextLoads() {
	}

}
