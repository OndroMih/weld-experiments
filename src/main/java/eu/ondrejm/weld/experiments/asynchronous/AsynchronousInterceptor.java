package eu.ondrejm.weld.experiments.asynchronous;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Asynchronous
@Interceptor
public class AsynchronousInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object executeAsynchronously(InvocationContext ctx) throws Exception {
        // TODO
        logger.info(() -> "Intercepted " + ctx.getMethod());
        return ctx.proceed();
    }
    
}
