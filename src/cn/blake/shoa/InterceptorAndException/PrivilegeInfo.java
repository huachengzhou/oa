package cn.blake.shoa.InterceptorAndException;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
public @interface PrivilegeInfo {
	public String name() default "";
}
