package eu.ondrejm.weld.experiments.asynchronous;

import eu.ondrejm.weld.experiments.containerStartup.StartUp;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import javax.enterprise.event.Observes;

public class AsynchronousBean {
    @Asynchronous
    public Future<String> executeAsynchronously() {
        // TODO
        return CompletableFuture.completedFuture("Done!");
    }
    
}
