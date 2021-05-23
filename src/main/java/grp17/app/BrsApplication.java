package grp17.app;

import grp17.rest.ContainerRestService;
import grp17.rest.HelloRestService;
import grp17.rest.PeopleRestService;
import grp17.rest.VehicleRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class BrsApplication extends Application {
    private final Set<Object> singletons = new HashSet<Object>();
    public BrsApplication() {
        // Register our hello service
        singletons.add(new HelloRestService());
        singletons.add(new VehicleRestService());
        singletons.add(new PeopleRestService());
        singletons.add(new ContainerRestService());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
