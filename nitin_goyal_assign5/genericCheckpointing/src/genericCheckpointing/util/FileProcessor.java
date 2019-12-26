package genericCheckpointing.util;

import java.io.File;
import java.util.Scanner;

public class FileProcessor {
	Scanner scan = null;
	public FileProcessor(String file)
	{
		try
		{
			scan = new Scanner(new File(file));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} 
	
	
	public String readfromfile()
	{
		String line = null;
			if(scan.hasNextLine())
			{
				 line = scan.nextLine();
			
			}
		return line;
	}

}
