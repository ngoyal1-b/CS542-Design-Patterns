package courseplanner.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import courseplanner.data.Student;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {



	public void filePrint(String pathToFile, Student student) throws IOException {

		File file=new File(pathToFile);

		FileWriter fileWriter=null;

		fileWriter=new FileWriter(file);
		fileWriter.write(""+student.getId()+": ");

		if(student.getGraduateCheck().equals("GradOK")) {
			Iterator<Character> iterator=student.getCompletedCourses().iterator();
			while(iterator.hasNext()) {
				fileWriter.write(" "+iterator.next());
			}

			fileWriter.write(" -- "+student.getSemesterCount()+" ");
			fileWriter.write(""+student.getStateChanges());
		}else {
			fileWriter.write("student does not graduate. -- "+student.getSemesterCount()+" "+student.getStateChanges());
		}
		fileWriter.close();
	}

	public void consolePrint(Student student) {

		System.out.print(student.getId()+": ");
		if(student.getGraduateCheck().equals("GradOk")) {
			Iterator<Character> iterator=student.getCompletedCourses().iterator();
			while(iterator.hasNext()) {
				System.out.print(" "+iterator.next());
			}
			System.out.print(" -- "+student.getSemesterCount()+" "+student.getStateChanges());
		}else {
			System.out.print("student does not graduate. -- "+student.getSemesterCount()+" "+student.getStateChanges());
		}
	}
}
