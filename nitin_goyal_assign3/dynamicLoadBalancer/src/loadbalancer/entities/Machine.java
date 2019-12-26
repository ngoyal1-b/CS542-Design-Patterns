package loadbalancer.entities;

import java.util.HashMap;
import java.util.Map;

public class Machine
{
	private String hostname;
	private Map<String,Service>hostedServices;
	
	public Machine()
	{
		hostedServices = new HashMap<>();
	}
	
	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Map<String, Service> getHostedServices() {
		return hostedServices;
	}

	public void setHostedServices(Map<String, Service> hostedServices) {
		this.hostedServices = hostedServices;
	}
	
	public void addService(Service sobj) {
		hostedServices.put(sobj.name,sobj);
	}
	
	
}