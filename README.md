#  Lambda Calculs Interpreter

# Resources:
* zeroturnaround blogs:
1. https://zeroturnaround.com/rebellabs/parsing-lambda-calculus-in-scala/
1. https://zeroturnaround.com/rebellabs/evaluating-lambda-calculus-in-scala/

This project is an application which is meant for Linux based machines and aims at making recommendations to GitHub developers based on the differences between two versions of the same application. We use the REST APIs of the akka toolkit as well as the actor pattern to send and receive messages between actors. It also uses gitHub APIs to stream open source applications from GitHub and clone the repositories into our local directories. This project uses Understand® (from Scitools) APIs to build dependency graphs for two versions of the applications so that we may compare the versions for differences and use those differences to suggest actions to the developers. You can read about the above-mentioned resources through the links given below:






## Getting Started

### Prerequisites
* JDK 8 and JRE 8 to be installed on the machine.
* SBT to be installed on the machine.
* Scala version 2.11.0 or later.


### Installing, Testing, and Running

Clone the project to your local repository:
```
git clone https://ametwally@bitbucket.org/ametwally/ahmed_metwally_hw4.git
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
* Enter the lambda expression: λx.x t
```


### Implementation Notes:

* ...