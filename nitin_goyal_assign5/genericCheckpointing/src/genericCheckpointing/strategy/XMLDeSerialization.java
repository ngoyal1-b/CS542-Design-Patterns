package genericCheckpointing.strategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLDeSerialization implements DeSerStrategy{
	
	@SuppressWarnings({ "static-access", "null" })
	@Override
	public Object processInput(FileProcessor f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String name;
		String type;
		String value;
		SerializableObject object;
		String line;
		Method m;
		
		Class<?> cls = null;
		Object obj = null;
		while((line=f.readfromfile())!=null)
		{
			if(line.contains("<DPSerialization>") || line.contains("</DPSerialization>"))
			{
				continue;
			}
			else if(line.contains("<complexType"))
			{
				String[] tokens = line.split("\"");
				try {
					cls = Class.forName(tokens[1]);
					obj = cls.newInstance();
				} catch (ClassNotFoundException | InstantiationException  | SecurityException e) {
					e.printStackTrace();
				}
				
			}
			else if(line.contains("</complexType")) {
				break;
			}
			else
			{
				String[] temp = line.split("<");
				name = temp[1].substring(0,temp[1].indexOf(" "));
				
				String[] temp1 = line.split(":");
				type = temp1[2].substring(0,temp1[2].indexOf(">")-1);
				
				String[] temp3 = line.split(">");
				value = temp3[1].substring(0,temp3[1].indexOf("<"));
				//System.out.println("name: " + name + " "+" type:"+ type+" value:"+ value);
				String mname = "set"+name;
				if(type.equals("int"))
				{
					//System.out.println("set"+name);
					try {
						m = obj.getClass().getMethod(mname, int.class);
						m.invoke(obj, Integer.parseInt(value));
					} catch (NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				if(type.equals("long"))
				{
					try {
						m = cls.getMethod(mname, long.class);
						m.invoke(obj, Long.parseLong(value));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("string"))
				{
					try {
						m = cls.getMethod(mname, String.class);
						m.invoke(obj,value);
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("boolean"))
				{
					try {
						m = cls.getMethod(mname, boolean.class);
						m.invoke(obj, Boolean.parseBoolean(value));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("double"))
				{
					try {
						m = cls.getMethod(mname, double.class);
						m.invoke(obj,Double.parseDouble(value));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("float"))
				{
					try {
						m = cls.getMethod(mname, float.class);
						m.invoke(obj, Float.parseFloat(value));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("short"))
				{
					try {
						m = cls.getMethod(mname, short.class);
						m.invoke(obj, Short.parseShort(value));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
				if(type.equals("char"))
				{
					try {
						m = cls.getMethod(mname, char.class);
						m.invoke(obj, value.charAt(0));
					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
					
				}
			}
				
			
		}
		object = (SerializableObject)obj; 
		try {
			Method m1 = obj.getClass().getMethod("toString");
			//System.out.println(m1.invoke(obj));
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}


}
