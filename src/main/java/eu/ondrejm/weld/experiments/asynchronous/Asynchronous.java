package eu.ondrejm.weld.experiments.asynchronous;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import javax.interceptor.InterceptorBinding;

/**
 * <p>Interceptor-binding qualifier to mark a method or class to be executed asynchronously. 
 * When marking a class, all methods are executed asynchronously.
 * <p>Marked methods must be either void or return a Future or CompletableFuture. 
 * If returning a value, CompletableFuture.completedFuture can be used to wrap it into a Future object.
 * <p>Inspired by http://jdevelopment.nl/cdi-based-asynchronous-alternative/
 */
@InterceptorBinding
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface Asynchronous {
}