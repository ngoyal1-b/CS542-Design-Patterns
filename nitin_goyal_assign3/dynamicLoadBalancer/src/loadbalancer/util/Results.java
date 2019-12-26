package loadbalancer.util;

import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	FileWriter outputPrint;
	public Results()
	{
		try {
			outputPrint = new FileWriter("output.txt");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void displayResultsOnConsole(String text) {
			System.out.println(text);
	}

	@Override
	public void printResultsToFile(String text){
		try
		{
		outputPrint.write(text+"\n");
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
