#  Recommending actions to GitHub developers based on changes made between two versions of the application

# Project members
  * Ahmed Metwally (678120810)
  * Samrudhi Nayak (652550698)
  * Eric Wolfson (678795352)

This project is an application which is meant for Linux based machines and aims at making recommendations to GitHub developers based on the differences between two versions of the same application. We use the REST APIs of the akka toolkit as well as the actor pattern to send and receive messages between actors. It also uses gitHub APIs to stream open source applications from GitHub and clone the repositories into our local directories. This project uses Understand® (from Scitools) APIs to build dependency graphs for two versions of the applications so that we may compare the versions for differences and use those differences to suggest actions to the developers. You can read about the above mentioned resources through the links given below:

* Akka toolkit : http://akka.io
* Dependency Graph: https://en.wikipedia.org/wiki/Dependency_graph
* Understand® APIs: https://scitools.com/
* GitHub APIs: https://developer.github.com/v3/

## (Important)
You must delete the fetched project folders as well as the analysis folder
between each run of the program (The udb files can just be overwritten)

## Bonus Parts
* 1) Results are stored in external files
* 2) Deleted functions (in addition to added functions) are analyzed
* 3) The called functions in every added and deleted function is listed in a separate    file

## Inputs:

* The language for your test projects (Example: java)
* A keyword to search for (Example: "square" as the keyword will look for all projects within the github repository with the word "square" in it's name)

## Output:

* For each project:
  Under "repo_projects" in the project root directory...
  -) A project folder called "analysis" with results is stored in the project name directory
  -) A list of all added and deleted functions are saved to a file    primaryDependencyGraphDifferences.txt in *that* directory
  -) Two directories are created addedfns and deletedfns in the analysis directory
  -) In each directory is a list of functions that are added (or deleted) in the form
     of text files. In each text file is a list of all functions called by the  function whose name is the file. For instance in functiona.txt, if there is functionz and functionw listed, then functiona calls functionz and functionw.
* For each project:
  Under "repo_projects in the project root directory...
  -) project folders called <name> and <name_v2> are created where "name" is the name of the project. Each folder contains the data for each version (v1 and v2 respectively). The udb files are created in just the homework 3 project root directory. 



## Getting Started

### Prerequisites
* JDK 8 and JRE 8 to be installed on the machine.
* SBT to be installed on the machine.
* Understand® installed on the machine.


### Installing, Testing, and Running

Clone the project to your local repository:
```
git clone https://ametwally@bitbucket.org/ametwally/ahmed_metwally_samrudhi_nayak_eric_wolfson_hw3.git
```


Copy the Understand jar file (in my case it is com.scitools.understand.plugin_1.1.3.jar) to the lib directory.  



Configure environmental variables for Understand. Example, for Linux users: open the ~/.bashrc and add the following. You need to replace [path-to-understand] by the absolute path of the directory where scitools package exists. 


```
export PATH=$PATH:[path-to-understand]/scitools/bin/linux64
export CLASSPATH=$CLASSPATH:[path-to-understand]/scitools/bin/linux64/Java/com.scitools.understand.plugin_1.1.3.jar

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:[path-to-understand]/scitools/bin/linux64/
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:"/usr/java/jre1.8.0_91/lib/amd64/"
```



To make sure that you build the code from scratch, navigate to the project's main directory, remove any pre-built files:
```
sbt clean
```


Then, build the project using: 
```
sbt compile
```



There are a couple of test cases implemented in this program. These test cases ensure that every method works as expected. You can test them using:
```
sbt "test-only UnitTest"
```


Also, there is one integration test that test the creation of the udb files, dependency graph, and the whole analysis.
```
sbt "test-only IntegAnalysisTest"
```



To execute the program from command line, use:
```
sbt run
```


Then the program should ask you to enter a language of your choice and a keyword to help narrow down the search for applications from github.
```
* Enter the language: java
* Enter the keyword: square
```

There is an error that gets generated for each version of the applications while being cloned

```
Error: -quiet is an unused argument and ignored.
```
 This error occurs since we have used the quiet command so as to not display the details of the creation of the udb files which Understand dumps onto the console while creating it. We used the "quiet" command to ensure that the output on the console is clean.

The program should then use the keyword and language preferences to clone the repositories matching the language and keyword descriptions into the local repository, build dependency graphs and calculate the differences between different versions of the application based on the dependency graphs.  


### Implementation Notes:

* We have used AKKA HTTP to make requests to get the JSON object from the URLs obtained according to a particular language and keyword pair input by the user. We then parse through the JSON object to get the clone_url from which we can clone the application into our local repository.
* We use GitHub developer APIs to clone two versions of the same application into our local machine.
* We then use Understand APIs to build the udb files from which to build dependency graphs on a function level.
* The dependency graphs of the different versions are then compared to obtain the differences between the versions which are given out as a recommendation to the developers so they may test the functions that have been added since the previous version of the application.
* If more than one project has the keyword that the user provides, the application will create only one analysis directory for the first project that was downloaded. It is just a matter of name confliction. We have the correct code for it, but couldn't test it because we exceeded our limit of HTTP requests.