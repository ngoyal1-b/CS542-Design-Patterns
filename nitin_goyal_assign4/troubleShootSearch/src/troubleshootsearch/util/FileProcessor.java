package troubleshootsearch.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
	
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;


public class FileProcessor {
	
	String technicalFile;
	String userFile;
	String synonymFile;

	public FileProcessor(String techincalFile,String userFile,String synonymFile)
	{		
		this.technicalFile = techincalFile;
		this.userFile = userFile;
		this.synonymFile = synonymFile;
		MyLogger.writeMessage("entered file processor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		
	}
	public void readfromfile(MyArrayList myarraylist,MyTree mytree)
	{
		List<String> data = new ArrayList<>();
		List<String> input = new ArrayList<>();
		Map<String,String>synonyms = new HashMap<>();
		String user_tokens = null;
		int count = 0;
		


		Scanner scan = null;
		Scanner scan1 = null;
		Scanner scan2 = null;
		try
		{
			scan = new Scanner(new File(technicalFile));
			scan1 = new Scanner(new File(userFile));
			scan2 = new Scanner(new File(synonymFile));
			while(scan.hasNextLine())
			{
				String tokens = scan.nextLine();
				count++;
				data.add(tokens);
				myarraylist.setMyarraylist(data);
				String[] info = tokens.split(" ");
				for(int i = 0;i<info.length;i++)
				mytree.setWord(info[i],count);
			}
			while(scan1.hasNextLine())
			{
			   user_tokens = scan1.nextLine();
			   input.add(user_tokens);
			   myarraylist.setInputlist(input);
			   mytree.setInputList(input);
			}
			while(scan2.hasNextLine())
			{
				String tokens = scan2.nextLine();
				String[] temp = tokens.split("=");
				synonyms.put(temp[0], temp[1]);
				myarraylist.setSynonyms(synonyms);
			}
			
		}
		catch(Exception e)
		{
			MyLogger.writeMessage("catched expection while reading a file", MyLogger.DebugLevel.ERROR);
		}
	}
	
}
