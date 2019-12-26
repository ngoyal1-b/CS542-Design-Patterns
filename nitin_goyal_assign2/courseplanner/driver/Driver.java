package courseplanner.driver;

import java.io.IOException;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;
import courseplanner.util.FileProcessor;
import courseplanner.util.Results;


public class Driver {
	public static void main(String[] args) throws IOException {

		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 arguments.");
			System.exit(0);
		}
		
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.readFile(args[0]);
		
		Student student=fileProcessor.getStudent();
		student.setPreferencePointer(0);
		student.setGraduateCheck("");
		
		CoursePlanner coursePlanner=new CoursePlanner();
		
		while(true) {
			if(student.getGraduateCheck().equals("GradOk") || student.getSemesterCount()==-1) {
				if(student.getSemesterCount()==-1)
					student.setSemesterCount(0);
				break;
			}else
				coursePlanner.requiredCoursesCheck(student);
		}
				
		Results results = new Results();
		results.filePrint(args[1], student);
		results.consolePrint(student);		
	}
}
