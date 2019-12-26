package troubleshootsearch.visitor;

import troubleshootsearch.element.BstTree;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;

public class ExactMatch implements VisitorInterface{

	String token;
	Results result;
	public ExactMatch(Results result)
	{
		MyLogger.writeMessage("inside exact match constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		this.result = result;
	}


	@Override
	public void visit(MyArrayList myarraylist) {
		// TODO Auto-generated method stub
		for(int i = 0;i<myarraylist.getMyarraylist().size();i++)
		{
			for(int j = 0;j<myarraylist.getInputlist().size();j++)
			if(myarraylist.getMyarraylist().get(i).contains(myarraylist.getInputlist().get(j)))
			{
				result.displayResultsOnConsole("EXACTMATCH : - " + myarraylist.getMyarraylist().get(i)+ "\n");
				result.printResultsToFile("EXACTMATCH : - " + myarraylist.getMyarraylist().get(i)+"\n");
			}
		}
	}

	@Override
	public void visit(MyTree mytree, BstTree btree) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
