package eu.ondrejm.weld.experiments.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import javax.inject.Inject;

public class AsynchronousBean {
    
    @Inject
    private Logger logger;
    
    @Asynchronous
    public CompletableFuture<String> executeAsynchronously() {
        logger.info(() -> "Running asynchronously in thread " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("Done!");
    }
    
}
