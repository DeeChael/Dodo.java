package net.deechael.dodo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Parameter {

    String name();

    String location() default "";

    Class<?> type();

    /**
     * The string must be executable python code
     * x means the parameter content
     * e.g.: len(x) > 1
     *
     * @return requirement
     */
    String mustBe() default "";

}
