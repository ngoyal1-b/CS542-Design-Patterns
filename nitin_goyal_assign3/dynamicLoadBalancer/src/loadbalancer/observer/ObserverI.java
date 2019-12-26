package loadbalancer.observer;


import java.util.List;

public interface ObserverI {
    void updateObservers(String serviceName, String URL, List<String> hostNames);
}
