package coursesRegistration.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	@Override
	public void displayResultsOnConsole(List<StudentInfo> students) {
		int averageRating = 0;
		int totalRating = 0;
		int i;
		for(i = 0;i<students.size();i++)
		{
			System.out.print(students.get(i).getId()+ ":");
			for(int j = 0; j<students.get(i).getCourses().size(); j++) {
				System.out.print(students.get(i).getCourses().get(j).getCourse() + " ");
			}
			System.out.println("::SatisfactionRating="+students.get(i).satisfaction);
			totalRating = totalRating + students.get(i).satisfaction;
		}
			averageRating = totalRating/i;
			System.out.println("\n" + "AverageSatisfactionRating="+ averageRating);
			
	}

	@Override
	public void printResultsToFile(List<StudentInfo> students, String outPutFileName){
		FileWriter outputPrint = null;
		try
		{
		outputPrint = new FileWriter(outPutFileName);
		int totalRating = 0;
		int averageRating = 0;
		int i;
		for(i = 0;i<students.size();i++)
		{	
			outputPrint.write(students.get(i).getId()+ ":");
			for(int j = 0; j<students.get(i).getCourses().size(); j++) 
			{
				outputPrint.write(students.get(i).getCourses().get(j).getCourse());
				outputPrint.write(",");
			}
			outputPrint.write("::SatisfactionRating="+ students.get(i).satisfaction +"\n");
			totalRating = totalRating + students.get(i).satisfaction;
		}
		averageRating = totalRating/i;
		outputPrint.write("\n" + "AverageSatisfactionRating="+ averageRating);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				outputPrint.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
