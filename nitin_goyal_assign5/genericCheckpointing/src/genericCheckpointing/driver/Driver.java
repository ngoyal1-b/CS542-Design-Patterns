
package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.List;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.MySpecialTypes;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;


public class Driver {
	public static List<SerializableObject> myrecord = new ArrayList<>();
    public static void main(String[] args) {
	
		if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}"))
		{
	
			System.out.println("Incorrect number of arguments");
			System.exit(0);
		}

    	FileProcessor fp = new FileProcessor(args[1]);
    	FileProcessor fp2 = new FileProcessor(args[1]);
    	Results results = new Results(args[2]);
    
    	String line;
    	int count = 0;
    	List<String> tokens = new ArrayList<>();
    	while((line =  fp.readfromfile())!= null) {
    		tokens.add(line);
    		if(line.contains("<complexType"))
    			count++;
    	}
    	
	
	ProxyCreator pc = new ProxyCreator();
	

	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 new StoreRestoreHandler()
								 );
		
	
	
	MyAllTypesFirst myFirst = null;
	MyAllTypesSecond  mySecond = null;
	MySpecialTypes  mySpecialT = null;
	
	
	SerializableObject myRecordRet = null;
	
	for(int x = 0; x<count; x++)
	{
		myRecordRet = ((RestoreI) cpointRef).readObj("XML",fp2);
		myrecord.add(myRecordRet);
		
	}
	

	
	int NUM_OF_OBJECTS = myrecord.size();
	for (int i=0; i<NUM_OF_OBJECTS; i++) {
		if(myrecord.get(i) instanceof MyAllTypesFirst) {
			myFirst = (MyAllTypesFirst) myrecord.get(i);
			//mySecond = (MyAllTypesSecond) myrecord.get(i);
	    ((StoreI) cpointRef).writeObj(myFirst,  "XML",results);
	    //((StoreI) cpointRef).writeObj(mySecond,  "XML");
		}
		else {
			mySpecialT = (MySpecialTypes) myrecord.get(i);
	    ((StoreI) cpointRef).writeObj(mySpecialT, "XML",results);
		}
		
	}

    results.closeFile();
    }
 
}
