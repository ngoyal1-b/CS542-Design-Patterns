package troubleshootsearch.driver;

import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.FileProcessor;
import troubleshootsearch.util.Results;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.visitor.ExactMatch;
import troubleshootsearch.visitor.SemanticMatch;
import troubleshootsearch.visitor.StemmingMatch;

public class Driver {
	public static void main(String[] args)
	{
	
		if (args.length != 6 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}"))
		{
	
			System.out.println("Incorrect number of arguments");
			System.exit(0);
		}

		MyArrayList myarraylist = new MyArrayList();
		MyTree mytree = new MyTree();
		
		MyLogger.setDebugValue(Integer.parseInt(args[4]));

		Results results = new Results(args[3]);
		
		FileProcessor fp = new FileProcessor(args[0],args[1],args[2]);
		fp.readfromfile(myarraylist,mytree);
		
		ExactMatch exactmatch = new ExactMatch(results);
		StemmingMatch stemmingmatch = new StemmingMatch(results);
		SemanticMatch semanticmatch = new SemanticMatch(results);
		
		myarraylist.accept(exactmatch);
		mytree.accept(stemmingmatch);
		myarraylist.accept(semanticmatch);
		
	}

}
