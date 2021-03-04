package javacore.generics;

/**
 * Created by askar on 04.06.2017.
 * Пример обобщенного класса, у которого один тип-параметр T.
 * Обобщенный класс может содержать и несколько тип-параметров,
 * которые перечисляются через запятую в угловых скобках, например <T,U>
 */
public class PairOfTheSameType<T> {
    private T first;
    private T second;

    public PairOfTheSameType() {
    }

    public PairOfTheSameType(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
