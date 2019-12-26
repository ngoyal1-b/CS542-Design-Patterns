package coursesRegistration.driver;


import java.util.List;

import coursesRegistration.util.Computing;
import coursesRegistration.util.CourseInfo;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.StudentInfo;

public class Driver {
	public static void main(String[] args) {

		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) 
		{

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}		 
		FileProcessor fileProcessor = new FileProcessor();
		List<StudentInfo> students = fileProcessor.fetchStudentsFromFile(args[0]);
		List<CourseInfo> courses = fileProcessor.fetchCoursesFromFile(args[1]);
		
		Computing computing = new Computing();
		computing.registerForCourses(courses, students);
		try
		{
		FileDisplayInterface fileDisplayInterface = new Results();
		fileDisplayInterface.printResultsToFile(students, args[2]);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		StdoutDisplayInterface stdoutDisplayInterface = new Results();
		stdoutDisplayInterface.displayResultsOnConsole(students);
	}
}
