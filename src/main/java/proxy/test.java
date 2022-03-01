package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        Factory factory=new Factory();
        InvocationHandler handler=new MyProxy(factory);
        //如果没有接口这里就没得填了
        Sell taobao=(Sell)Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(),handler);
        float price=taobao.sell(1);
        System.out.println(price);
    }
}
