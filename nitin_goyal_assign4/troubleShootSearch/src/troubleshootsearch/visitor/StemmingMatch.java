package troubleshootsearch.visitor;

import troubleshootsearch.element.BstTree;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;

public class StemmingMatch implements VisitorInterface{
	
	Results result;
	public StemmingMatch(Results result)
	{
		MyLogger.writeMessage("inside stemming match constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		this.result = result;
		
	}
	@Override
	public void visit(MyArrayList myarraylist) {
		// TODO Auto-generated method stub	
	}


	@Override
	public void visit(MyTree mytree, BstTree btree) {
		for(int i = 0;i<mytree.getInputList().size();i++)
		{
			String token = mytree.getInputList().get(i).split(" ")[0];
			btree.inorderTraversal(btree.root,token,mytree);
		}
		result.displayResultsOnConsole("\nSTEMMING MATCH : - \nword Count = "+mytree.getCount()+"\n");
		result.printResultsToFile("\nSTEMMING MATCH : - \nword Count = "+mytree.getCount()+"\n");
		result.displayResultsOnConsole("Line numbers = ");
		result.printResultsToFile("Line numbers = ");
		for(int j = 0;j<mytree.getLineNumbersFoundIn().size();j++)
		{
			result.displayResultsOnConsole(mytree.getLineNumbersFoundIn().get(j) + " ");
			result.printResultsToFile(mytree.getLineNumbersFoundIn().get(j) + " ");
		}
		result.displayResultsOnConsole("\n");
		result.printResultsToFile("\n");
		//result.closeFile();
		
	}

}
