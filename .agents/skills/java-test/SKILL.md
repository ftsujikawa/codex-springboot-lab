---
name: java-test
description: Create, improve, and run JUnit 5 tests in Java Maven and Spring Boot projects. Use when the user asks to generate Java tests, investigate test failures, or improve test coverage.
---

# Java Test Skill

## Purpose

Create reliable JUnit 5 tests for Java and Spring Boot projects.

## Workflow

1. Read the repository AGENTS.md instructions.
2. Inspect pom.xml and existing tests.
3. Identify the target Java class.
4. Read references/junit-guidelines.md.
5. Identify normal cases, boundaries, and exceptions.
6. Create or update JUnit 5 tests.
7. Run scripts/run-tests.sh from this skill directory.
8. Investigate failures.
9. Report results in Japanese.

## Rules

- Do not change production code unless requested.
- Do not remove tests merely to make the build pass.
- Do not add dependencies without approval.
- Do not hide failing test results.
- Keep changes focused on the requested class.

## Output

Report:
- Modified files
- Added test cases
- Test command
- Test results
- Remaining issues
