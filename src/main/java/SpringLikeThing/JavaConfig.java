package SpringLikeThing;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;
    private Map<Class, Class> int2ImplClass;


    public JavaConfig(String packageToScan, Map<Class, Class> int2ImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.int2ImplClass = int2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return int2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than one impl");
            }
            return classes.iterator().next();
        });
    }
}
