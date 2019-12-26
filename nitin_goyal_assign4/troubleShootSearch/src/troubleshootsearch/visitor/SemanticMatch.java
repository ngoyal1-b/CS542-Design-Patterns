package troubleshootsearch.visitor;

import troubleshootsearch.element.BstTree;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;
import troubleshootsearch.util.MyLogger;
import troubleshootsearch.util.Results;

public class SemanticMatch implements VisitorInterface{

	Results result;
	public SemanticMatch(Results result) {
		MyLogger.writeMessage("inside semantic match constructor",MyLogger.DebugLevel.CONSTRUCTOR);
		this.result = result;
	}
	@Override
	public void visit(MyArrayList myarraylist) {
		
		boolean flag = false;
		
		for(int i = 0;i<myarraylist.getInputlist().size();i++)
		{
			for(int j = 0;j<myarraylist.getMyarraylist().size();j++)
			{
				for(int k = 0;k<myarraylist.getMyarraylist().get(j).split(" ").length;k++)
				{
					String token = myarraylist.getMyarraylist().get(j).split(" ")[k];
					if(myarraylist.getSynonyms().containsKey(token.toLowerCase()))
					{
						flag = true;
						result.displayResultsOnConsole("\nSEMANTICMATCH : - " + myarraylist.getMyarraylist().get(j));
						result.printResultsToFile("\nSEMANTICMATCH : - " + myarraylist.getMyarraylist().get(j));
						result.closeFile();
					}
					if(flag == true)
						break;
				}
			}
		}

		}
		

	@Override
	public void visit(MyTree mytree, BstTree btree) {
		// TODO Auto-generated method stub
		
	}

}
