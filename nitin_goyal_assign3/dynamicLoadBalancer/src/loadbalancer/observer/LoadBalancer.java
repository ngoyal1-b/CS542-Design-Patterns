package loadbalancer.observer;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

//import loadbalancer.subject.Cluster;

public class LoadBalancer
{
	//private Cluster cluster;

	public Map<String,ServiceManager> indexMap = new HashMap<>();
	
	public Map<String, ServiceManager> getIndexMap() {
		return indexMap;
	}
	public void setIndexMap(Map<String, ServiceManager> indexMap) {
		this.indexMap = indexMap;
	}

	public void addInstance(String service,String host)
	{		
		if(!indexMap.containsKey(service))
		{
			System.out.println("Service doesn't exists");
		}
		else
		{
			ServiceManager smobj = indexMap.get(service);
			if(!smobj.getHostnames().contains(host)){
				List<String> l = smobj.getHostnames();
				l.add(host);
			}
		}	
	}
	public void removeService(String service)
	{
		indexMap.remove(service);
	}
		
}