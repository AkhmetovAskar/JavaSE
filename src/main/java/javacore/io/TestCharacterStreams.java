package javacore.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

/**
 * Пример работы с символьными потоками
 * Все символьные потоки наследуются от абстрактных классов Reader и Writer.
 * Потоки нужно обязательно закрывать
 */
public class TestCharacterStreams {
    public static void main(String[] args) throws IOException {
        //Символьные потоки для чтения/записи в файл. Читают/пишут по одному символу за раз
        FileReader in = null;
        FileWriter out = null;
        URL urlText = TestCharacterStreams.class.getResource("/text.txt");
        URL urlTextCopy = TestCharacterStreams.class.getResource("/textCopy.txt");
        File file = new File(urlText.getPath());
        File fileCopy = new File(urlTextCopy.getPath());
        try {
            in = new FileReader(file);
            out = new FileWriter(fileCopy);

            int c;
            //читает из исходного файла по одному символу и пишет также по одному символу в другой файл
            //метод read() возвращает код символа в таблице unicode, то есть значение от 0 до 65535 включительно
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}