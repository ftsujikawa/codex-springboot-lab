package com.example.codexlab;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.codexlab.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
class CodexSpringbootLabApplicationTests {

	@Test
	void mainStartsContextWithCalculatorService(@Autowired CalculatorService calculatorService) {
		assertNotNull(calculatorService);
	}

}
