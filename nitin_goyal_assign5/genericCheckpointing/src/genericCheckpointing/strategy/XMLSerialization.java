package genericCheckpointing.strategy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.Results;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements SerStrategy {

	@Override
	public void processInput(SerializableObject sObject,Results results) {
		//Results results = new Results();
		Class<?> cls = sObject.getClass();
		Field[] fieldList = cls.getDeclaredFields();
		results.printResultsToFile("<DPSerialization>");
		results.printResultsToFile(" <complexType xsi:type="+"\""+cls.getName()+"\""+">");
		for (Field fields : fieldList) {
			String fieldName = fields.getName();
			String methodName = "get" + fieldName;
			Method getterMethod = null;
			try {
				getterMethod = cls.getMethod(methodName);
			} catch (NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
			Object invokeRet = null;
			try {
				invokeRet = getterMethod.invoke(sObject);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
				
				e1.printStackTrace();
			}
			if (fields.getType() == int.class) {		
				try {
					
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:int"+"\""+">"+(int)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException | SecurityException e) {
					
					e.printStackTrace();
				}
			}
			if (fields.getType() == long.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:long"+"\""+">"+(long)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if (fields.getType() == java.lang.String.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:string"+"\""+">"+(String)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if (fields.getType() == boolean.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:boolean"+"\""+">"+(boolean)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {	
					e.printStackTrace();
				}
			}
			if (fields.getType() == double.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:double"+"\""+">"+(double)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if (fields.getType() == float.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:float"+"\""+">"+(float)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if (fields.getType() == short.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:short"+"\""+">"+(short)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			if (fields.getType() == char.class) {
				try {
					results.printResultsToFile("  <"+fieldName+" xsi:type="+"\""+"xsd:char"+"\""+">"+(char)invokeRet+"</"+fieldName+">");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			
			}
		results.printResultsToFile(" </complexType>");
		results.printResultsToFile("</DPSerialization>");
	}
	//results.closeFile();
	}

