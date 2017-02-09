#  Lambda Calculus Interpreter

This project is intended to act as a simple lambda calculus interpreter. It takes a lambda expression as its input, then parse it and then uses beta reduction grammar to get the most reduced form of the expression.



## Getting Started

### Prerequisites
* JDK 8 and JRE 8 to be installed on the machine.
* SBT to be installed on the machine.
* Scala version 2.11.0 or later.


### Installing, Testing, and Running

Clone the project to your local repository:
```
git clone https://github.com/aametwally/Lambda-Calculus-Interpreter.git
```

To make sure that you build the code from scratch, navigate to the project's main directory, remove any pre-built files:
```
sbt clean
```


Then, build the project using: 
```
sbt compile
```


There is one test case implemented in this program. This test case ensures that the parser works as expected. You can test it using:
```
sbt "test-only LambdaParserTest"
```


To execute the program from command line, use:
```
sbt run
```


Then the program should ask you to enter the lambda expression of your choice, then the output should be the parsed lambda expression.
```
* Enter the lambda expression: (λx.x) t
```


### Implementation Notes:
* The current implementation parsers any lambda expression, builds the AST, then print it out.
