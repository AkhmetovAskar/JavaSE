package javacore.generics;

/**
 * Created by askar on 04.06.2017.
 * Пример класса, содержащего обобщенные методы.
 * Тип-параметр пишется после всех модификаторов (public, static и др.) и перед возвращаемым типом метода.
 * Обобщенные методы можно определять как в обобщенных классах, так и в простых.
 */
public class GenericMethod {

    public static <T> String getClassName(T param){
        return param.getClass().getName();
    }

    public static <T> T printClassNameAndReturn(T param) {
        System.out.printf(param.getClass().getName());
        return param;
    }


    public static <T> T printParamAndReturn(String param) {
        System.out.println(param);
        return null;
    }

    public static <T> void strangeMethod() {
    }

}
