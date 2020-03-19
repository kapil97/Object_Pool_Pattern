# CS542: Assignment 3
## Name: Kamleshwar Ragava
Name: Jithin Jose
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in numberPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile threadPlay/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile threadPlay/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Use the below command to run the prime Detector.

```commandline
ant run-DprimeDetector -buildfile threadPlay/src/build.xml \
-DinputNumStream="<input file path>" \
-DnumThreads="<number of threads>" \
-Dcapacity="<capacity of Results file>" \
-DpersisterServiceIP="<persister service ip address>" \
-DpersisterServicePort="<persister service port number>" \
-DdebugValue="<debug value>"
```
### Use the below command to run the persister Service.
```commandline
ant run-DpersisterService -buildfile threadPlay/src/build.xml \
-Dport="<port number>" \
-DoutputNumStream="<output file name>" \
```
-----------------------------------------------------------------------
## Description:

In Progress ...

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 03/xx/2020


