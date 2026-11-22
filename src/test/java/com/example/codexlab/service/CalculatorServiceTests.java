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
	void addsIntegersAtTheLimitsOfIntRange() {
		int upperNeighbor = Integer.MAX_VALUE - 1;
		int lowerNeighbor = Integer.MIN_VALUE + 1;

		int upperResult = calculator.add(upperNeighbor, 1);
		int lowerResult = calculator.add(lowerNeighbor, -1);

		assertEquals(Integer.MAX_VALUE, upperResult);
		assertEquals(Integer.MIN_VALUE, lowerResult);
	}

	@Test
	void wrapsToOppositeLimitWhenAdditionOverflows() {
		int maximum = Integer.MAX_VALUE;
		int minimum = Integer.MIN_VALUE;

		int aboveMaximum = calculator.add(maximum, 1);
		int belowMinimum = calculator.add(minimum, -1);

		assertEquals(minimum, aboveMaximum);
		assertEquals(maximum, belowMinimum);
	}

	@Test
	void wrapsToZeroWhenAddingTwoMinimumInts() {
		int result = calculator.add(Integer.MIN_VALUE, Integer.MIN_VALUE);

		assertEquals(0, result);
	}

	@Test
	void dividesIntegers() {
		assertEquals(3, calculator.divide(12, 4));
		assertEquals(2, calculator.divide(7, 3));
		assertEquals(-2, calculator.divide(-7, 3));
		assertEquals(0, calculator.divide(0, 3));
	}

	@Test
	void dividesByTheNonzeroNeighborsOfZero() {
		int dividend = Integer.MAX_VALUE;

		int positiveDivisorResult = calculator.divide(dividend, 1);
		int negativeDivisorResult = calculator.divide(dividend, -1);

		assertEquals(dividend, positiveDivisorResult);
		assertEquals(-dividend, negativeDivisorResult);
	}

	@Test
	void truncatesTowardZeroWithNegativeDivisor() {
		int divisor = -3;

		int negativeQuotient = calculator.divide(7, divisor);
		int positiveQuotient = calculator.divide(-7, divisor);

		assertEquals(-2, negativeQuotient);
		assertEquals(2, positiveQuotient);
	}

	@Test
	void returnsZeroWhenDividendMagnitudeIsSmallerThanDivisorMagnitude() {
		int divisor = 3;

		int positiveDividendResult = calculator.divide(2, divisor);
		int negativeDividendResult = calculator.divide(-2, divisor);

		assertEquals(0, positiveDividendResult);
		assertEquals(0, negativeDividendResult);
	}

	@Test
	void returnsMinimumIntWhenDivisionOverflows() {
		int dividend = Integer.MIN_VALUE;
		int divisor = -1;

		int quotient = calculator.divide(dividend, divisor);

		assertEquals(Integer.MIN_VALUE, quotient);
	}

	@Test
	void dividesMinimumIntByOneWithoutOverflow() {
		int quotient = calculator.divide(Integer.MIN_VALUE, 1);

		assertEquals(Integer.MIN_VALUE, quotient);
	}

	@Test
	void dividesNextIntAboveMinimumByNegativeOneWithoutOverflow() {
		int dividend = Integer.MIN_VALUE + 1;

		int quotient = calculator.divide(dividend, -1);

		assertEquals(Integer.MAX_VALUE, quotient);
	}

	@Test
	void dividesByMinimumIntAtTheMagnitudeBoundary() {
		int divisor = Integer.MIN_VALUE;

		int equalDividendQuotient = calculator.divide(Integer.MIN_VALUE, divisor);
		int smallerMagnitudeQuotient = calculator.divide(Integer.MIN_VALUE + 1, divisor);

		assertEquals(1, equalDividendQuotient);
		assertEquals(0, smallerMagnitudeQuotient);
	}

	@Test
	void rejectsZeroDivisor() {
		assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
	}

	@Test
	void rejectsZeroDivisorWhenDividendIsAlsoZero() {
		int dividend = 0;
		int divisor = 0;

		assertThrows(IllegalArgumentException.class, () -> calculator.divide(dividend, divisor));
	}

	@Test
	void rejectsZeroDivisorForNegativeDividend() {
		int dividend = Integer.MIN_VALUE;
		int divisor = 0;

		assertThrows(IllegalArgumentException.class, () -> calculator.divide(dividend, divisor));
	}
}
