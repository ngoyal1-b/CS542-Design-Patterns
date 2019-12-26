package courseplanner.state;

import courseplanner.context.CoursePlanner;
import courseplanner.data.Student;

public class NotGraduated implements CoursePlannerStateI {

	CoursePlanner coursePlanner;
	public NotGraduated(CoursePlanner CoursePlannerIn) {
		coursePlanner = CoursePlannerIn;
	}

	public void requiredCoursesCheck(Student student) {
		student.setSemesterCount(-1);
	}
}
