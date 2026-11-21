package com.example.codexlab.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTests {

	private final CalculatorService calculator = new CalculatorService();

	@Test
	void addsIntegers() {
		assertEquals(7, calculator.add(3, 4));
		assertEquals(1, calculator.add(-3, 4));
		assertEquals(4, calculator.add(4, 0));
	}

	@Test
	void dividesIntegers() {
		assertEquals(3, calculator.divide(12, 4));
		assertEquals(2, calculator.divide(7, 3));
		assertEquals(-2, calculator.divide(-7, 3));
		assertEquals(0, calculator.divide(0, 3));
	}

	@Test
	void rejectsZeroDivisor() {
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
	}
}
