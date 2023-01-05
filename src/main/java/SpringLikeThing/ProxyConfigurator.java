package SpringLikeThing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t,Class implClass);
}
