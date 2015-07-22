package eu.ondrejm.weld.experiments.containerStartup;

import eu.ondrejm.weld.experiments.WeldConfiguration;
import eu.ondrejm.weld.experiments.asynchronous.AsynchronousInterceptor;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@ApplicationScoped
public class Starter {
    public static void main(String[] args) {
        Weld builder = new Weld()
         
       .disableDiscovery()
                .addPackages(true, WeldConfiguration.class)
                .addInterceptor(AsynchronousInterceptor.class);
        
        try (WeldContainer weld = builder.initialize()) {
            // triggers @Initialized(ApplicationScoped) and weld closes as closeable resource
        }
    }
    
    @Inject
    private Logger logger;
    
    private boolean containerStarted = false;
    
    @Inject
    @StartUp
    private Event<Object> startupEvent;
    
    /**
     * Observes {@literal @}Initialized event for application scope, which is triggered when the scope starts. 
     * This is right when the container is initialized.
     * @param event
     */
    public void logContainerStartup(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (!containerStarted) {
            containerStarted = true;
            logger.info("Weld container started");
            startupEvent.fire("StartUp");
        }
    }
    
}
