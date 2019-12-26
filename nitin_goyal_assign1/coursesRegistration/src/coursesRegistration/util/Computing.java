package coursesRegistration.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Computing {
	/*https://howtodoinjava.com/java-sorting-guide/
		for sorting student data on the basis of year
	*/
	public void registerForCourses(List<CourseInfo> courses, List<StudentInfo> students){
		Collections.sort(students, new Comparator<StudentInfo>() {

			public int compare(StudentInfo s1, StudentInfo s2) {
				return s2.getYear().compareTo(s1.getYear());
			}
		});
		for(StudentInfo student : students)
		{
			int i=0;
			for(String pref : student.getPref())
			{
				if(student.courses.size()<3)
				{
					CourseInfo course = getCourse(pref, courses);
					if(course!=null && course.capacity>0 && isFeasible(student.courses, course))
					{
						student.courses.add(course);
						course.capacity = course.capacity - 1;
						student.satisfaction += 9-i;
					}
				}else
					break;
				i++;
			}
		}
	}

	private boolean isFeasible(List<CourseInfo> courses, CourseInfo course) {
		for(CourseInfo crs : courses)
		{
			if(crs.timings.equals(course.timings))
				return false;
		}
		return true;
	}

	private CourseInfo getCourse(String pref, List<CourseInfo> courses) {
		for(CourseInfo course : courses)
		{
			if(pref.equals(course.course))
				return course;
		}
		return null;
	}
}
