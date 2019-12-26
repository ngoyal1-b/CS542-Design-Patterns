
Name - Nitin Goyal
Bnumber - B00767934

Date of submission -> November 17,2019

Assignment 4


Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------

## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------

## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0="technicalInfo.txt" -Darg1="userInput.txt" -Darg2="synonyms.txt" -Darg3="output.txt" -Darg4=0

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile toubleShootSearch/src/build.xml tarzip

-----------------------------------------------------------------------
Data Structures used:

1) ArrayList
2) Binary Search Tree -> Complexity  O(logn)


Mylogger:

Switch Cases:

0 -> to print out all the error, if anyone + output of program

1 -> to print the constructors being called + output of program

2 -> which accept method is called + output of program


Output:-

		Output is printing on console and into file name output.txt

     [java] EXACTMATCH : - If Debian has a problem detecting the drive, it could be that the portable drive is not receiving enough power.
     [java]
     [java] STEMMING MATCH : -
     [java] word Count = 2
     [java] Line numbers = 2 4
     [java]
     [java] SEMANTICMATCH : - All products from AMD have a compatible CPU as far as dSeaGate is concerned.



Notes:
1) Not able to disable the output from console using mylogger file

2) In exact match other than exact matching of two words it will also match strings like 
	eg. "compatible process" can also be matched with "compatible processor".

3) In semantic match I am only matching the key of map with the word present in list.

4) In stemming match I am using inorder traversal to compare the first word of input with word present in tree for comparing I am using indexOf() method



References:

http://www.newthinktank.com/2013/03/binary-tree-in-java/


Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: [11/17/2019]







