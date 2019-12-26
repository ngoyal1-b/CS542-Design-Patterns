package troubleshootsearch.util;



import java.io.FileWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface,FileDisplayInterface{
	
	FileWriter outputPrint = null;
	public Results(String outputFile)
	{
		MyLogger.writeMessage("result constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		try {
			outputPrint = new FileWriter(outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			MyLogger.writeMessage("error while making an output file", MyLogger.DebugLevel.ERROR);
		}
		
	}

	
	public void displayResultsOnConsole(String message)
	{
		System.out.print(message);
	}
	
	public void printResultsToFile(String message){
		try
		{
			outputPrint.write(message);
		}
		catch(IOException e)
		{
			MyLogger.writeMessage("error while writing to an output file", MyLogger.DebugLevel.ERROR);
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
			MyLogger.writeMessage("error while closing an output file", MyLogger.DebugLevel.ERROR);
			e.printStackTrace();
		}
	}
	
	
}
