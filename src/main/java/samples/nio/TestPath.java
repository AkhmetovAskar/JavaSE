package samples.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Пример работы с интерфейсом Path
 * Интерфейс Path - это путь в файловой системе. Состоит из имен файлов и списка папок.
 * Интерфейс используется больше для работы именно с путем, нежели с реально существующим файлом
 * или папкой. Поэтому файл или папка на который указывает экземпляр Path может и не существовать.
 */
public class TestPath {
    public static void main(String[] args) throws IOException {

        //Получаем путь к папке (или файлу)
        Path path = Paths.get("C:\\Windows\\System32\\drivers\\etc");

        //Вызываем разные методы
        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        //Метод normalize() убрирает избыточные элементы в пути, такие как "." - символ текущей дериктории
        //и ".." - символ родительской директории
        //В данном примере уберет "." после Windows и someFolder\..
        path = Paths.get("C:\\Windows\\.\\System32\\someFolder\\..\\drivers\\etc");
        System.out.format("normalize : %s%n", path.normalize());

        //Различные методы конвертации
        path = Paths.get("C:\\Windows\\System32\\drivers\\etc");
        System.out.format("toUri : %s%n", path.toUri());
        System.out.format("toAbsolutePath : %s%n", path.toAbsolutePath());
        System.out.format("toRealPath : %s%n", path.toRealPath());
        //Создадим путь к несуществующему файлу
        Path test = Paths.get("test.txt");
        //toAbsolutePath прибавит спереди рабочую директорию, откуда запускается класс
        System.out.format("toAbsolutePath : %s%n", test.toAbsolutePath());
        //А такой вызов выбросит java.nio.file.NoSuchFileException
        //System.out.format("toRealPath : %s%n", test.toRealPath());

        //Пути можно соединять
        //Часть которая присоединяется не должна включать корневой элемент,
        //если же она включает, то в итоге результат будет равен этой присоединяещейся части
        Path part1 = Paths.get("C:\\Windows\\System32");
        Path part2 = Paths.get("drivers\\etc");
        Path part3 = Paths.get("C:\\Users");
        System.out.format("resolve : %s%n", part1.resolve(part2));
        //В данном примере результатом соединения будет part3 = "C:\\Users"
        System.out.format("resolve (with root) : %s%n", part1.resolve(part3));

        //Можно пользоваться итератором
        //Проходит по всем элементом пути начиная от самого ближнего к корню
        //В данном случае от Windows до etc
        path = Paths.get("C:\\Windows\\System32\\drivers\\etc");
        for (Path name : path) {
            System.out.println(name);
        }

        //Пути можно сравнивать и вычислять "начинается на" и "заканчивается на"
        if (path.equals(test)) {
            System.out.println("paths equals");
        }
        if (path.startsWith("C:\\")) {
            System.out.println("path startsWith C:\\");
        }
        if (path.endsWith("etc")) {
            System.out.println("path endsWith etc");
        }
    }
}