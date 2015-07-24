package eu.ondrejm.weld.experiments.asynchronous;

import eu.ondrejm.weld.experiments.containerStartup.StartUp;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class AsynchronousStartUp {
    
    @Inject
    private AsynchronousBean asyncBean;
    
    @Inject
    private Logger logger;
    
    /**
     * Example of how an asynchronous method of another bean can be executed  
     */
    public void run(@Observes @StartUp Object event) throws InterruptedException, ExecutionException {
        logger.info(() -> "Running in thread " + Thread.currentThread().getName());
        asyncBean.executeAsynchronously()
            .thenAccept(returnValue -> {
                logger.info(() -> "Got return value from asynchronous execution: (" + returnValue + ")");
            });
    }

    /**
     * Example how an observer method can be executed asynchronously
     */
    @Asynchronous
    public void runAsync(@Observes @StartUp Object event) {
        logger.info(() -> "Running in thread " + Thread.currentThread().getName());
    }
    

}
