package tutorial.io.byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Пример работы с байтовыми потоками
 * Все байтовые потоки наследуются от абстрактных классов InputStream и OutputStream.
 * Потоки нужно обязательно закрывать
 * Все другие потоки (символьные и т.д.) построены на байтовых потоках
 */
public class TestByteStreams {
    public static void main(String[] args) throws IOException {

        //Байтовые потоки для чтения/записи в файл. Читают/пишут по одному байту за раз
        FileInputStream in = null;
        FileOutputStream out = null;

        URL urlText = TestByteStreams.class.getResource("/text.txt");
        URL urlTextCopy = TestByteStreams.class.getResource("/textCopy.txt");
        File file = new File(urlText.getPath());
        File fileCopy = new File(urlTextCopy.getPath());
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(fileCopy);
            int c;
            //читает из исходного файла по одному байту и пишет также по одному байту в другой файл
            while ((c = in.read()) != -1) {
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