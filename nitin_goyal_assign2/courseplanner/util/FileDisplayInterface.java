package courseplanner.util;

import java.io.IOException;

import courseplanner.data.Student;

public interface FileDisplayInterface {
	public void filePrint(String pathToFile, Student student) throws IOException;	
}
