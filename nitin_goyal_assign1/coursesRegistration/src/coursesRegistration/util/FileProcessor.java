package coursesRegistration.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor {
	public List<StudentInfo> fetchStudentsFromFile(String fileName) {
		List<StudentInfo> students = new ArrayList<StudentInfo>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNext()) {
				String[] tokens = scan.nextLine().split(" ");
				String id = tokens[0];
				String[] temparray = tokens[1].split("::");
				String pref = temparray[0];
				String[] temp = pref.split(",");
				String year = temparray[1];
				StudentInfo studentsnw = new StudentInfo();
				studentsnw.setId(id);
				studentsnw.setPref(temp);
				studentsnw.setYear(year);

				students.add(studentsnw);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
		return students;
	}

	public List<CourseInfo> fetchCoursesFromFile(String fileName) {
		List<CourseInfo> courses = new ArrayList<CourseInfo>();
		String file;
		Scanner sc = null;
		try {
			file = "courseInfo.txt";
			sc = new Scanner(new File(file));
			while (sc.hasNextLine()) {
				String[] tokens = sc.nextLine().split(" ");
				String course1 = tokens[0];
				String[] temparray = tokens[1].split("CAPACITY:");
				String[] temparray2 = temparray[1].split(";CLASS_TIMING:");
				String capacity = temparray2[0];
				int capacityInt = Integer.parseInt(capacity);
				String timing = temparray2[1];

				CourseInfo coursesnw = new CourseInfo();
				coursesnw.setCapacity(capacityInt);
				coursesnw.setCourse(course1);
				coursesnw.setTimings(timing);

				courses.add(coursesnw);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
		return courses;
	}
}
