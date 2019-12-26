package loadbalancer.observer;

import java.util.List;

public class ServiceManager implements ObserverI
{
	private String key;
	private String URL;
	private List<String> hostnames;
	private int index = 0;
	public String getKey() {
		return key;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setKey(String key) {
		this.key = key;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public List<String> getHostnames() {
		return hostnames;
	}
	public void setHostnames(List<String> hostnames) {
		this.hostnames = hostnames;
	}

	@Override
	public void updateObservers(String serviceName, String URL, List<String> hostNames) {
		
	}
	
	
}