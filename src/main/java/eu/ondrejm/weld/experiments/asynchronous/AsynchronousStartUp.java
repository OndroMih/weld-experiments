package eu.ondrejm.weld.experiments.asynchronous;

import eu.ondrejm.weld.experiments.containerStartup.StartUp;
import java.util.concurrent.Future;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class AsynchronousStartUp {
    
    @Inject
    private AsynchronousBean asyncBean;
    
    public void run(@Observes @StartUp Object event) {
        Future<String> asyncResult = asyncBean.executeAsynchronously();
    }
    

}
