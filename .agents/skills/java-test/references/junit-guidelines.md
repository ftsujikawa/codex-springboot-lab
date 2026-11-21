# JUnit 5 Guidelines

## Test design

Use the Arrange-Act-Assert pattern.

Cover:
- Normal inputs
- Zero and negative values
- Boundary values
- Invalid inputs
- Expected exceptions

## Java conventions

- Use org.junit.jupiter.api.Test.
- Use Assertions.assertEquals.
- Use Assertions.assertThrows for exceptions.
- Prefer unit tests for business logic.
- Avoid unnecessary Spring context startup.
- Use descriptive method names.

## CalculatorService examples

For add:
- add(2, 3) -> 5
- add(-2, 3) -> 1
- add(0, 0) -> 0

For divide:
- divide(10, 2) -> 5
- divide(7, 2) -> 3
- divide(10, 0) -> IllegalArgumentException

For integer overflow:
- Verify behavior according to the implementation contract.
- Do not assume overflow must throw unless specified.
