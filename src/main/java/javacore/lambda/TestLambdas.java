package javacore.lambda;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Примеры использования лямбд в Java
 */
public class TestLambdas {
    /**
     * Функиональный интерфейс - с одним абстрактным методом,
     * но лучше ещё и аннотацию добавить
     */
    @FunctionalInterface
    interface DoLater {
        void call();
    }

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public <T> Set<T> getSet(Supplier<Set<T>> supplier) {
        return supplier.get();
    }

    /**
     * Простейший пример лямбда-выражения + присваивание лямбды функциональному интерфейсу
     */
    public DoLater doLater = () -> System.out.println("call doLater()");

    public static void main(String[] args) {
        TestLambdas testLambdas = new TestLambdas();
        //вызов лямбда-выражения
        testLambdas.doLater.call();
        //а теперь присваиваем другое лямбда-выражение
        testLambdas.doLater = () -> System.out.println("something new!");
        //и опять вызываем
        testLambdas.doLater.call();

        //ещё примеры лямбда-выражений
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + testLambdas.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + testLambdas.operateBinary(20, 10, subtraction));

        //примеры ссылок на методы
        //1. Ссылка на статический метод класса вида Класса::статический_метод
        System.out.println("1 + 2 = " + testLambdas.operateBinary(1, 2, Integer::sum));
        //2. Ссылка на метод экземпляра класса вида Экземпляр::метод
        System.out.println("3 + 4 = " + testLambdas.operateBinary(1, 2, testLambdas::sum));
        //3. Ссылка на метод класса вида Класс:метод
        //Следующие сортировки эквивалентны, таким образом выражение String::compareToIgnoreCase
        //эквивалентно  (s1, s2) -> s1.compareToIgnoreCase(s2)
        String[] stringArray = {"aaa", "bbb", "ccc", "ddd"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        Arrays.sort(stringArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        //4. Ссылка на конструктор вида Класс::new
        //Следущие вызовы эквивалетные, таким образом выражение () -> new HashSet<String>()
        //эквивалентно HashSet<String>::new
        System.out.println("set = " + testLambdas.getSet(() -> new HashSet<String>()));
        System.out.println("set = " + testLambdas.getSet(HashSet<String>::new));
    }
}