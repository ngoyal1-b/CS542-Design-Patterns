package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.strategy.SerStrategy;
import genericCheckpointing.strategy.XMLDeSerialization;
import genericCheckpointing.strategy.XMLSerialization;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;


public class StoreRestoreHandler implements InvocationHandler
{

public Object invoke(Object proxy, Method m, Object[] args) throws Throwable{
	 Object obj = null;
	 if(m.getName().equals("readObj"))
	 {
		 if(args[0].equals("XML"))
		 {
			 XMLDeSerialization xmldeserialization = new XMLDeSerialization();
			 obj = xmldeserialization.processInput((FileProcessor) args[1]);
			 return obj;
		 }
	 }
	 if(m.getName().equals("writeObj"))
	 {
		 if(args[1].equals("XML"))
		 {
			 SerStrategy s = new XMLSerialization();
			 serializeData((SerializableObject)args[0], s,(Results)args[2]);
		 }
	 }
	 return null;
}

 public void serializeData(SerializableObject sObject, SerStrategy sStrategy,Results results) {
            sStrategy.processInput(sObject,results);
  }

}