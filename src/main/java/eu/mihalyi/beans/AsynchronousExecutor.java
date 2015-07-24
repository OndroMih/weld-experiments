package eu.mihalyi.beans;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;

/**
 * Qualifier to mark executors of type Executor to be injected into AsynchronousInterceptor. 
 * Executors have to be of Dependent scope in order to be created for eery asynchronous call.
 * If no executor is provided via CDI mechanism, default executor is allocated from Java ForkJoinPool.
 * 
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,
		ElementType.TYPE})
@Documented
public @interface AsynchronousExecutor {
}