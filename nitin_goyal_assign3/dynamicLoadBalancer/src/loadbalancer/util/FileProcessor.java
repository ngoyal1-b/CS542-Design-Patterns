package loadbalancer.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import loadbalancer.subject.Cluster;
import loadbalancer.util.Results;


enum Cluster_op{
	CLUSTER_OP__SCALE_UP,
	CLUSTER_OP__SCALE_DOWN
}

enum Service_op{
	SERVICE_OP__ADD_SERVICE,
	SERVICE_OP__REMOVE_SERVICE,
	SERVICE_OP__ADD_INSTANCE,
	SERVICE_OP__REMOVE_INSTANCE
}

public class FileProcessor
{
	Results results;
	Cluster cobj;
	public FileProcessor(Results results)
	{
		this.results = results;
		cobj = new Cluster(results);
	}
	
	public void fetchdatafromfile(String file)
	{		
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String [] tokens = scan.nextLine().split(" ");				
				if(Cluster_op.CLUSTER_OP__SCALE_UP.toString().equals(tokens[0]))
				{
					cobj.addmachine(tokens[1]);
				}
				if(Cluster_op.CLUSTER_OP__SCALE_DOWN.toString().equals(tokens[0]))
				{
					cobj.removemachine(tokens[1]);
				}
				if(Service_op.SERVICE_OP__ADD_SERVICE.toString().equals(tokens[0]))
				{
					String temp = tokens[3];
					String[] host = temp.split(",");
					List<String> al = new ArrayList<>();
					for(String h : host)
						al.add(h);
					cobj.addservice(tokens[1],tokens[2],al);
				}
				if(Service_op.SERVICE_OP__ADD_INSTANCE.toString().equals(tokens[0]))
				{
					cobj.addinstance(tokens[1],tokens[2]);
				}
				if(Service_op.SERVICE_OP__REMOVE_INSTANCE.toString().equals(tokens[0]))
				{
					cobj.removeinstance(tokens[1], tokens[2]);
				}
				if(Service_op.SERVICE_OP__REMOVE_SERVICE.toString().equals(tokens[0]))
				{
					cobj.removeservice(tokens[1]);
				}
				if(tokens[0].equals("REQUEST"))
				{
					cobj.handlerequest(tokens[1]);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scan.close();
		}
		cobj.closeFile();
		
	}
	
	
	
	
}