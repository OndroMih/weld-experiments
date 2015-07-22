package eu.ondrejm.weld.experiments.asynchronous;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface Asynchronous {
}