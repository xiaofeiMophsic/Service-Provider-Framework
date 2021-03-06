# 服务提供者框架（Service-Provider-Framework）
服务提供者框架demo
## 说明      
服务提供者框架是在静态工厂方法（不是 GoF 里的工厂方法模式）的基础上构成的，它的原理是：多个服务提供者（Service Provider）实现一个服务，系统为服务提供者的客户端提供多个实现，并把他们从多个实现中解耦出来，例如 **JDBC** 的实现。
## 构成    
服务提供者框架有三个重要组件和一个可选组件：
* 服务接口（Service Interface），由提供者实现；
* 提供者注册API（Provider Registration API），系统用来注册实现，由客户端访问；
* 服务访问API（Service Access API），客户端用来获取服务实例入口；     
* 可选组件：服务提供者接口（Service Provider Interface），负责创建服务实现的实例。     

## 实例
```java
// Service Interface
public interface Service {
    // some code
}

// Service provider interface
public interface Provider {
    Service newService();
}

public class Services {
    private Services(){}
    
    private static final Map<String, Provider> providers = 
        new ConcurrentHashMap<String, Provider>();
    public static final String DEFAULT_PROVIDER_NAME = "<def>";
    
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }
    
    // Provider registration API
    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }
    
    // Service access API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }
    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if(null == p) throw new IllegalArgumentsException("No provider registered with name " + name);
        return p.newService();
    }
}
```
## 参考
[1] Joshua Bloch. *Effective Java, Second Edition*[M].Addison-Wesley, Boston, 2009.ISBN:0321356683.
