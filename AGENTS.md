# Codex Project Instructions

## Project
- Language: Java 21
- Framework: Spring Boot
- Build: Maven
- Testing: JUnit 5

## Coding rules
- Follow existing Java conventions.
- Use constructor injection.
- Keep controllers thin.
- Put business logic in service classes.
- Do not change public APIs without approval.
- Do not add dependencies without approval.

## Testing
- Write JUnit 5 tests for new business logic.
- Cover normal cases and edge cases.
- Run ./mvnw test after changes.
- Do not remove failing tests to make builds pass.

## Safety
- Never expose secrets.
- Never modify production credentials.
- Do not run destructive commands without approval.
- Do not push changes without approval.

## Reporting
- Respond in Japanese.
- List modified files.
- Summarize changes.
- Report executed tests and their results.
- Explain any unresolved issues.
