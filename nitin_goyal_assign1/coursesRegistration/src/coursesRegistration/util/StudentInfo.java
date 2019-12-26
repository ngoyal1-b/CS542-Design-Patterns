package coursesRegistration.util;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {
	String id;
	String[] pref;
	String year;
	List<CourseInfo> courses = new ArrayList<CourseInfo>();
	
	public List<CourseInfo> getCourses() {
		return courses;
	}
	int satisfaction;
	

	public String[] getPref() {
		return pref;
	}
	public void setPref(String[] temp) {
		pref = temp;
	}
	public String getId() {
		return id;
	}
	public void setId(String idIN) {
		id = idIN;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String yearIN) {
		year = yearIN;
	}
	
}
