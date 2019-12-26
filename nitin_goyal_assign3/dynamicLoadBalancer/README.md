# CS542: Assignment 3
# Name: Nitin Goyal

Assignment Submission Date : 1/01/2019

Number of Slack Days used : 2 days


Following are the commands and the instructions to run ANT on your project.
## Note: build.xml is present in dynamicLoadBalancer/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

##Command: ant -buildfile nitin_goyal_assign3/dynamicLoadBalancer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compile code.

-----------------------------------------------------------------------
## Instruction to compile:

##Command: ant -buildfile nitin_goyal_assign3/dynamicLoadBalancer/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile nitin_goyal_assign3/dynamicLoadBalancer/src/build.xml run -Darg0="input.txt" -Darg1="output.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

Observer pattern is used.

Hashmap:
I created Hashmap with string and a service object, with key containig the string of service and the value is service manager object.
all the services are redirected to hashmap to keep the services and host updated

Subject:
Cluster -> it keeps track of incoming request and send it to observer

Observer:
LoadBalancer 
ServiceManager


Output:

	 [java] Cluster Scaled Up
     [java] Cluster Scaled Up
     [java] Cluster Scaled Up
     [java] Service Added
     [java] Processed Request - Service_URL::https://binghamton.edu/csx42/grades Host::host1
     [java] Cluster Scaled Up
     [java] Processed Request - Service_URL::https://binghamton.edu/csx42/grades Host::host2
     [java] Service Added
     [java] Processed Request - Service_URL::https://binghamton.edu/students/info Host::host4
     [java] Instance Added
     [java] Processed Request - Service_URL::https://binghamton.edu/csx42/grades Host::host3
     [java] Service removed
     [java] Processed Request - Service_URL::https://binghamton.edu/csx42/grades Host::host4
     [java] Service removed
     [java] Invalid Service


Notes:
1)Trie data structure is not used



citations:

https://beginnersbook.com/2013/12/hashmap-in-java-with-example/ -> for understanding hashmap

http://tutorials.jenkov.com/java/enums.html -> for using enums




-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [11/04/2019]


"# csx42-fall-2019-assign3-ngoyal1-b" 
