package generics;

/**
 * Created by askar on 04.06.2017.
 * Пример обобщенного класса, у которого несколько типов-параметров T, U.
 * Конечно же обобщенный класс может содержать и больше типов-параметров
 */
public class PairOfTheDiffType<T, U> {
    private T first;
    private U second;

    public PairOfTheDiffType() {
    }

    public PairOfTheDiffType(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
