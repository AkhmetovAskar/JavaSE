package javase.collections;

import java.util.Arrays;

public class TestCollections {
    public static void main(String[] args) {

        String[] array = new String[] { "First", "Second", "Third", "Fourth" };

        // Стандартный метод
        System.out.println(array.toString());

        // Используем Arrays.toString() чтоб вывести массив в читаемом виде
        System.out.println(Arrays.toString(array));

        String[] arr1 = new String[] { "Fifth", "Sixth" };
        String[] arr2 = new String[] { "Seventh", "Eight" };
        String[][] arrayOfArray = new String[][] { arr1, arr2 };

        // Стандартный метод
        System.out.println(arrayOfArray);
        System.out.println(Arrays.toString(arrayOfArray));

        // Чтобы вывести в читаемом виде "массив массивов" используем Arrays.deepToString()
        System.out.println(Arrays.deepToString(arrayOfArray));

        String[] names = {"Alex", "Brian", "Charles", "David"};

        String[] copyOfNames = Arrays.copyOf(names, names.length);
        String[] partialNames = Arrays.copyOfRange(names, 0, 2);

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(copyOfNames));
        System.out.println(Arrays.toString(partialNames));

    }
}
