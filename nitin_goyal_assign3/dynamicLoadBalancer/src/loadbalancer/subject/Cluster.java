package loadbalancer.subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import loadbalancer.entities.Machine;
import loadbalancer.entities.Service;
import loadbalancer.observer.LoadBalancer;
import loadbalancer.observer.ObserverI;
import loadbalancer.observer.ServiceManager;
import loadbalancer.util.Results;

public class Cluster implements SubjectI{
	LoadBalancer lobj = new LoadBalancer();
	Results results;
	public Cluster(Results results) {
	 this.results = results;
	}
	private Map<String, Machine>machines = new HashMap<>();
	
	public Map<String, Machine> getMachines() {
		return machines;
	}
	public void setMachines(Map<String, Machine> machines) {
		this.machines = machines;
	}
	public void addmachine(String host)
	{
		if(machines.containsKey(host))
			return;
		Machine mobj = new Machine();
		mobj.setHostname(host);
		machines.put(host, mobj);
		results.displayResultsOnConsole("Cluster Scaled Up");
		results.printResultsToFile("Cluster Scaled Up");
	}
	public void removemachine(String host)
	{
		if(machines.containsKey(host)) {
			machines.remove(host);
			Map<String, ServiceManager> map = lobj.getIndexMap();
			for(String key : map.keySet()){
				ServiceManager serviceManager = map.get(key);
				serviceManager.getHostnames().remove(host);
			}
			results.displayResultsOnConsole("Cluster Scaled Down");
			results.printResultsToFile("Cluster Scaled Down");
		}
	}
	
	public void addservice(String service,String url,List<String> host)
	{
		Service sobj = new Service();
		ServiceManager smobj = new ServiceManager();
		
		smobj.setHostnames(host);
		smobj.setKey(service);
		smobj.setURL(url);
		
		sobj.setName(service);
		sobj.setURL(url);
		
		Map<String,ServiceManager> h = lobj.getIndexMap();
		if(!h.containsKey(service)){
			h.put(service,smobj);
			lobj.setIndexMap(h);
			results.displayResultsOnConsole("Service Added");
			results.printResultsToFile("Service Added");
		} else{
			ServiceManager serviceManager = h.get(service);
			for(String hs : host){
				if(!serviceManager.getHostnames().contains(hs)){
					serviceManager.getHostnames().add(hs);
				}
			}
		}
		for(String hostin : host)
		{
			if(machines.containsKey(hostin))
			{
				Machine mboj = machines.get(hostin);
				mboj.addService(sobj);
			}
			else
			{
				results.displayResultsOnConsole("Machine Doesn't exist");
				results.printResultsToFile("Machine Doesn't exist");
			}
		}
	}
	
	
	public void addinstance(String service,String host)
	{
		if(!machines.containsKey(host))
		{
			results.displayResultsOnConsole("Machine Doesn't exist");
			results.printResultsToFile("Machine Doesn't exist");
		}
		else
		{
			Service sobj = new Service();
			sobj.setName(service);
			machines.get(host).getHostedServices().put(service, sobj);
			lobj.addInstance(service,host);
			results.displayResultsOnConsole("Instance Added");
			results.printResultsToFile("Instance Added");
		}
			
	}
	public void removeservice(String service)
	{
		for(String s : machines.keySet())
		{
			Machine machine = machines.get(s);
			machine.getHostedServices().remove(service);
		}
		lobj.removeService(service);
		results.displayResultsOnConsole("Service removed");
		results.printResultsToFile("Service removed");
		
	}
	public void removeinstance(String serviceName, String host)
	{
		if(machines.containsKey(host)){
			machines.get(host).getHostedServices().remove(serviceName);
		}
		Map<String,ServiceManager> h = lobj.getIndexMap();
		if(h.containsKey(serviceName)){
			h.get(serviceName).getHostnames().remove(host);
		}
	}
	
	public void handlerequest(String service)
	{
		if(lobj.indexMap.containsKey(service)){
			int i = lobj.indexMap.get(service).getIndex();
			if(i>=lobj.indexMap.get(service).getHostnames().size())
			{
				i=0;
			}
			results.displayResultsOnConsole("Processed Request - Service_URL::"+lobj.indexMap.get(service).getURL()+" Host::"+lobj.indexMap.get(service).getHostnames().get(i));
			results.printResultsToFile("Processed Request - Service_URL::"+lobj.indexMap.get(service).getURL()+" Host::"+lobj.indexMap.get(service).getHostnames().get(i));
			lobj.indexMap.get(service).setIndex(i+1);

		}else{
			results.displayResultsOnConsole("Invalid Service");
			results.printResultsToFile("Invalid Service");
		}
	}
	@Override
	public void registerObserver(ObserverI o) {
		
	}
	@Override
	public void removeObserver(ObserverI o) {
		
	}
	@Override
	public void notifyObservers(String serviceName, String URL, List<String> hostNames) {
		
	}
	public void closeFile()
	{
		results.closeFile();
	}
	
	
	
	
}