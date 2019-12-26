# CS542: Assignment 1
# Name: Nitin Goyal

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
## Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

##Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compile code.

-----------------------------------------------------------------------
## Instruction to compile:

##Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="student_coursePrefs.txt" -Darg1="courseInfo.txt" -Darg2="registration_results.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

For this project,I used List as a datastructure, because it provides faster access to elements and we can dynamically add or remove elements,
it is object-oriented, so we can extend from it and add functionality if needed.

I am assigning courses to students by sorting the student list on basis of there year so that THIRD_YEAR students get courses first, then SECOND_YEAR
and so on. I am checking for capacity constraint in course and timings of two preffered courses cannot be same.
Courses are assigned in the order student requested i.e. firstly all three courses will be assigned to first student and after that it will move to next student.

Output:
100:A B D ::SatisfactionRating=23 //for students having three preffered courses
125:F H ::SatisfactionRating=6 //for students getting less than three courses
AverageSatisfactionRating=14


Notes:
1) If any student is not able to get 3 preffered courses, space will be left blank
2) If studentId is not numeric(100-999) it will still assign courses to other id like(11a)
3) Multiple entries exception not handled it will assign the courses to both id.


citations:
https://howtodoinjava.com/java-sorting-guide/ -> for sorting list of student on basis of year(THIRD_YEAR,SECOND_YEAR,FIRST_YEAR).
https://www.baeldung.com/java-read-file -> for reading contents of file using scanner.



-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [09/19/2019]


"# csx42-fall-2019-assign1-ngoyal1-b" 
