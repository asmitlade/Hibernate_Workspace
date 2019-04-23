package com.mac.helper;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyHelper implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		String result = null;
		if(method.getName().equalsIgnoreCase("withdraw")) {
			if(((Integer)args[1]) > 200000)
				throw new IllegalArgumentException("Get Approval from RBI to withdraw more than 2,00,000 amount");
			else
				result = (String)proxy.invokeSuper(target, args);
		}
		return result;
	}

}
