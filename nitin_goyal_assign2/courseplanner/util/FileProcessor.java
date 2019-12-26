package courseplanner.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import courseplanner.data.Student;

import java.io.BufferedReader;
import java.io.EOFException;

public class FileProcessor {
	
	Student student = new Student();

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void readFile(String fileName) {
		File file = new File(fileName);
		FileReader fr;
		try {
			if(file.length()==0) {
				throw new EOFException();
			}
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line=null;
			while((line = br.readLine()) != null){

				student.setId(Integer.parseInt(line.substring(0, line.indexOf(":"))));
				String subString=line.substring(line.indexOf(":")+1);
				for(int iterator=0;iterator<subString.length();iterator++) {
					if(Character.isAlphabetic(subString.charAt(iterator)))
						student.getPreferredCourses().add(subString.charAt(iterator));
				}
				
			}
			br.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (EOFException exception) {
			System.err.println("Error: Empty File.");
			exception.printStackTrace();
			System.exit(0);
		} catch (IOException exception) {
			exception.printStackTrace();
		}		
	}	
}
