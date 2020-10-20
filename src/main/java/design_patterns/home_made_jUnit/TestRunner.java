package design_patterns.home_made_jUnit;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestRunner {

    @SneakyThrows
    public void runAllTestsForClassByName(String className){
        Class<?> type= Class.forName(className);
        runAllTestForClass(type);

    }
    @SneakyThrows
    public void runAllTestForClass(Class<?> type){ //aClass ||clazz
//        Constructor constructor = type.getConstructor(String.class);
//        constructor.newInstance("fghjk")
        Object o = type.getDeclaredConstructor().newInstance();
        runAllTest(o);

    }


    @SneakyThrows
    public void runAllTest(Object o){
        int modifiers = o.getClass().getModifiers();
        Modifier.isAbstract(modifiers);
        Method[] methods = o.getClass().getMethods();
        for(Method metod: methods){
            if(metod.getName().startsWith("test")||metod.isAnnotationPresent(MyTest.class)){
                metod.invoke(o);
            }

        }
        /*   Field[] declaredFields = o.getClass().getDeclaredFields();
        for(Field field: declaredFields){
            field.setAccessible(true);
            field.set(o,12);

        }*/

    }
}
