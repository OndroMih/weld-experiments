package eu.ondrejm.weld.experiments.asynchronous;

import eu.mihalyi.beans.AsynchronousExecutor;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Asynchronous
@Interceptor
public class AsynchronousInterceptor {

    @Inject
    private Logger logger;
    
    @Inject
    @AsynchronousExecutor
    private Instance<Executor> executorInjector;

    @AroundInvoke
    public Object executeAsynchronously(InvocationContext ctx) throws Exception {
        // TODO
        logger.info(() -> "Intercepted " + ctx.getMethod());
        Supplier<Object> asyncExecutor = () -> {
            try {
                Future asyncResult = (Future)ctx.proceed();
                return asyncResult.get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
        if (executorInjector.isUnsatisfied()) {
            return CompletableFuture.supplyAsync(asyncExecutor);
        } else {
            Executor executor = executorInjector.get();
            return CompletableFuture.supplyAsync(asyncExecutor, executor);
        }
    }
    
}
