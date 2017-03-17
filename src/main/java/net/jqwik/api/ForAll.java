package net.jqwik.api;

import org.junit.platform.commons.annotation.Testable;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Testable
public @interface ForAll {
	String value() default "";
}
