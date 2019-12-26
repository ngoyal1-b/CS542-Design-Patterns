package genericCheckpointing.util;

import java.io.FileWriter;
import java.io.IOException;

public class Results{
	
	FileWriter outputPrint = null;
	public Results(String file)
	{
		try {
			outputPrint = new FileWriter(file);
		} catch (IOException e) {
			System.out.println("exception while opening a file");
		}
		
	}

	
	public void printResultsToFile(String message){
		try
		{
			outputPrint.write(message + "\n");
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public void closeFile()
	{
		try
		{
			outputPrint.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
