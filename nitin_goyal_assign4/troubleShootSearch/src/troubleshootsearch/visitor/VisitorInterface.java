package troubleshootsearch.visitor;

import troubleshootsearch.element.BstTree;
import troubleshootsearch.element.MyArrayList;
import troubleshootsearch.element.MyTree;

public interface VisitorInterface {
	
	public void visit(MyArrayList myarraylist);
	public void visit(MyTree mytree,BstTree btree);
	
}
