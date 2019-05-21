package io;

import java.io.*;
import java.net.URL;

/**
 * Пример работы с буферизоваными потоками
 * Чтобы создать буферизованный поток нужно просто передать в его конструктор обычный поток. Работает как Декоратор
 * Для байтовых потоков используются BufferedInputStream и BufferedOutputStream,
 * для символьных потоков используются BufferedReader и BufferedWriter
 * У Буферизованных потоков вывода есть такая вещь как "сброс" (flush) буфера.
 * Некоторые классы буферизованных потоков вывода поддерживают "авто сброс" (autoflush).
 * Можно также в ручную вызвать метод flush(). Этот метод есть у любого выходного потока,
 * но эффект будет только для буферизованного потока
 */
public class TestBufferedStreams {
    public static void main(String[] args) throws IOException {
        //Символьные потоки для чтения/записи в файл. Читают/пишут по одному символу за раз
        BufferedReader in = null;
        BufferedWriter out = null;
        URL urlText = TestCharacterStreams.class.getResource("/text.txt");
        URL urlTextCopy = TestCharacterStreams.class.getResource("/textCopy.txt");
        File file = new File(urlText.getPath());
        File fileCopy = new File(urlTextCopy.getPath());
        try {
            in = new BufferedReader(new FileReader(file));
            out = new BufferedWriter(new FileWriter(fileCopy));

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
