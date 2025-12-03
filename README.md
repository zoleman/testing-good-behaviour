# testing-good-behaviour

## Description  
`testing-good-behaviour` is a small test-automation / behavior-driven testing project in Java + Gherkin — a playground for experimenting with writing automated tests that verify “good behavior”. It’s meant as a learning sandbox: to understand how automated testing frameworks, test structure, and good practices come together.

## Scope  
- It gives hands-on experience with test automation and behavior-driven development — a great fit if someone learning coding and want to try structured testing.  
- Learn how to write tests in Java (with Gherkin scenarios), manage dependencies (via Maven), and run a test suite — useful skills for real-world software development.  
- It helps one appreciate the discipline of automated testing: repeatable, reliable checks that reduce bugs and help maintain code quality over time.

## Dependencies
This project uses the following libraries and tools (managed through Maven):

### Main Dependencies
- **Selenium Java (4.38.0)** – Browser automation for interacting with web pages.
- **dotenv-java (3.2.0)** – Loads environment variables from a `.env` file.
- **WebDriverManager (6.3.2)** – Automatically handles browser driver binaries.
- **Cucumber Java (7.31.0)** – Enables behavior-driven testing with Gherkin feature files.

### Test Dependencies
- **JUnit Jupiter API (5.14.1)** – Core testing framework used for assertions and test structure.
- **Cucumber JUnit Platform Engine (7.31.0)** – Integrates Cucumber with the JUnit 5 test engine.
- **JUnit Platform Suite API (1.14.1)** – Supports running grouped/suite-based tests on the JUnit 5 platform.

### Build Plugin
- **Maven Surefire Plugin (3.2.5)** – Executes the test suite; configured to run tests in a single thread and avoid module-path issues.
  

## Installation / Setup  
```bash
git clone https://github.com/zoleman/testing-good-behaviour.git  
cd testing-good-behaviour  
# no extra install needed — Maven will handle dependencies  
```

## Running the tests
```
mvn test
```
