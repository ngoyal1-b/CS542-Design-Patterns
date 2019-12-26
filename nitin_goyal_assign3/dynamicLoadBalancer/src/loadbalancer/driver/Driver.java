package loadbalancer.driver;

import loadbalancer.util.FileProcessor;
import loadbalancer.util.Results;

public class Driver{
	
	public static void main(String[] args) {
		if(args.length != 2)
		{
			System.out.println("Incorrect number of arguments");
		}
		Results results = new Results();
		FileProcessor fileprocesssor = new FileProcessor(results);
		fileprocesssor.fetchdatafromfile(args[0]);
		
		//Results results = new Results();
		
	}
}