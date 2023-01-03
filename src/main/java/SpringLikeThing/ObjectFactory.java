package SpringLikeThing;

import lombok.SneakyThrows;

import java.lang.invoke.SerializedLambda;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("SpringLikeThing");

    public static ObjectFactory getInstance(){return ourInstance;};
    private ObjectFactory(){}

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (type.isInterface()){
            implClass = config.getImplClass(type);
        }
        return implClass.getDeclaredConstructor().newInstance();
    }
}
