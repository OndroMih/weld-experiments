package eu.ondrejm.weld.experiments.util.producers;

import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class LoggerProducer {
    
    @Produces
    @Dependent
    public Logger getLogger(InjectionPoint point) {
        String className = point.getMember().getDeclaringClass().getName();
        return Logger.getLogger(className);
    }
}
