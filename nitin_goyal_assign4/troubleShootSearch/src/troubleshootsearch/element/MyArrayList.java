package troubleshootsearch.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import troubleshootsearch.util.MyLogger;
import troubleshootsearch.visitor.VisitorInterface;

public class MyArrayList {

	public List<String> myarraylist = new ArrayList<>();
	public List<String> inputlist = new ArrayList<>();
	Map<String,String> synonyms = new HashMap<>();

	public Map<String, String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Map<String, String> synonyms) {
		this.synonyms = synonyms;
	}

	public List<String> getMyarraylist() {
		return myarraylist;
	}

	public List<String> getInputlist() {
		return inputlist;
	}

	public void setInputlist(List<String> inputlist) {
		this.inputlist = inputlist;
	}

	public void setMyarraylist(List<String> myarraylist) {
		this.myarraylist = myarraylist;
	}
	
	public void accept(VisitorInterface visitor)
	{
		MyLogger.writeMessage("accept method of myarraylist", MyLogger.DebugLevel.ACCEPT);
		visitor.visit(this);
	}
	
}
