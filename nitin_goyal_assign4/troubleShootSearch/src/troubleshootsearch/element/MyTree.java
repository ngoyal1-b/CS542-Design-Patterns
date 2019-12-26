package troubleshootsearch.element;

import java.util.ArrayList;
import java.util.List;

import troubleshootsearch.util.MyLogger;
import troubleshootsearch.visitor.VisitorInterface;

public class MyTree {

	BstTree btree = new BstTree();
	private String word;
	int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	private List<Integer> lineNumbersFoundIn = new ArrayList<>();
	List<String> inputList = new ArrayList<>();
	public List<String> getInputList() {
		return inputList;
	}
	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word,int count) {
		this.word = word;
		btree.addNode(word,count);
	}
	public List<Integer> getLineNumbersFoundIn() {
		return lineNumbersFoundIn;
	}
	public void setLineNumbersFoundIn(List<Integer> lineNumbersFoundIn) {
		this.lineNumbersFoundIn = lineNumbersFoundIn;
	}
	
	public void accept(VisitorInterface visitor)
	{
		MyLogger.writeMessage("accept method of mytree", MyLogger.DebugLevel.ACCEPT);
		visitor.visit(this,btree);
	}
}



