package javase.generics;

/**
 * Created by askar on 12.06.2017.
 * Wildcard - подстановочный символ ?, означает "любой тип"
 */
public class Wildcards {

    //обычно ? используется в простых случаях, когда тип не важен
    public boolean hasNulls(PairOfTheSameType<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    //? можно ограничить через extends (? extends Type).
    //Это означает, что тип может быть подтипом Type или Type
    public void printNumbers(PairOfTheSameType<? extends Number> pair) {
        System.out.println("First : " + pair.getFirst().toString());
        System.out.println("Second : " + pair.getSecond().toString());
    }

    //аналогично методу выше, только с использованием тип-параметра
    public <T extends Number> void printNumbers2(PairOfTheSameType<T> pair) {
        System.out.println("First : " + pair.getFirst().toString());
        System.out.println("Second : " + pair.getSecond().toString());
    }

    //? можно ограничить через super (? super Type).
    //Это означает, что тип может быть любым супертипом Type
    public void test(PairOfTheSameType<? super Integer> pair) {

    }

}
