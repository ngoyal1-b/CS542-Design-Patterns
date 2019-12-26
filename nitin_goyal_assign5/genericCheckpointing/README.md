
Name - Nitin Goyal
Bnumber - B00767934

Date of submission -> December 7,2019

Assignment 5


Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------

## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------

## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0="deserser" -Darg1="MySpecialTypes2.txt" -Darg2="results.txt" -Darg3=0;

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------
Data Structures used:

1) ArrayList -: to store values like datatypes,values and other fields.


Description :
To create a generic library to serialize and deserialize objects, using dynamic proxy and java reflection.Java reflection is implemented using 
strategy pattern. Creating class like MyAllTypesFirst,MyAllTypesSecond,MySpecialTypes using java reflection and accessing get and set methods 
using java reflection. Setting method using deserialization of input file and after deserializing getting value of field and value using 
serialization.
value which are not provided into classes by default is set to 0 using default constructor.




Output:-
		Output is printing into file name results.txt

Notes:
1) Didn't implement mode and debug level
2) Order of output file is not maintained and if fields are not provided default value is stored





Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: [12/07/2019]







