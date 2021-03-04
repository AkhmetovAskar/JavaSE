package javacore.generics;

public class TestGenerics {

    public static void main(String[] args) {

        //Вызов обобщенного метода
        System.out.println(GenericMethod.getClassName("SomeString"));
        /*
            А можно вызвать и так. В большинстве случаев компилятор может определить какой тип должен быть у T,
            но бывает что не может. Тогда используется такая форма.
         */
        System.out.println(GenericMethod.<Integer>getClassName(123));
        //Тип-параметр может быть любым ссылочным типом, включая массивы и другие обобщенные типы
        PairOfTheSameType<String[]> a1;
        PairOfTheSameType<int[]> a2;
        PairOfTheSameType<PairOfTheSameType<Integer>> a3;

        PairOfTheSameType<Number> pairNumber = new PairOfTheSameType<>(1, 2.0);
        PairOfTheSameType<Double> pairDouble = new PairOfTheSameType<>(1.0, 2.0);
        PairOfTheSameType<Integer> pairInteger = new PairOfTheSameType<>(1, 2);

        Wildcards wildcards = new Wildcards();
        wildcards.printNumbers(pairNumber);
        wildcards.printNumbers(pairDouble);
        wildcards.printNumbers(pairInteger);
    }
}