package loadbalancer.subject;



import java.util.List;

import loadbalancer.observer.ObserverI;

public interface SubjectI {
	
	public void registerObserver(ObserverI o);
	public void removeObserver(ObserverI o);
	public void notifyObservers(String serviceName, String URL, List<String> hostNames);
	
}
