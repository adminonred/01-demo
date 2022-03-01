package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy implements InvocationHandler {
    Object target=null;

    public MyProxy() {
    }

    public MyProxy(Sell target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        float price=(float)method.invoke(target,args);
        return price+100;
    }
}
