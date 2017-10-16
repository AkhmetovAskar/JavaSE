package samples.generics;

import java.io.Serializable;

/**
 * Created by askar on 04.06.2017.
 * Типы-параметры можно ограничивать.
 * T extends SomeType - означает что тип Т может быть только подтипом SomeType или самим SomeType
 */
public class BoundType<T extends Number> {

    //можно использовать и классы и интерфейсы в качестве ограничений (и даже обощенные интерфейсы)
    public static <T extends Comparable<T>> T getSomething() {
        return null;
    }

    //можно использовать несколько ограничений, через символ "&".
    //В данном случае он работает как AND, то есть T должен быть подтипом и Comparable<T> и Serializable одновременно
    public static <T extends Comparable<T> & Serializable> T getSomething2() {
        return null;
    }

    //можно использовать и интерфейсы и классы, но можно использовать только один класс, и он долже стоять первым
    public static <T extends Number & Comparable<T> & Serializable> T getSomething3() {
        return null;
    }
}
