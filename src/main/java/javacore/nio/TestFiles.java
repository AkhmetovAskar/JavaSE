package javacore.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

/**
 * Пример работы с классом Files
 */
public class TestFiles {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Windows\\System32\\drivers\\etc");

        //Базовые атрибуты файла (папки) - есть во всех файловых системах
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());

        System.out.println("----------------------------------");

        try {
            //Атрибуты файлов (папок) для "DOS-систем"
            DosFileAttributes attrDos = Files.readAttributes(path, DosFileAttributes.class);
            System.out.println("isReadOnly is " + attrDos.isReadOnly());
            System.out.println("isHidden is " + attrDos.isHidden());
            System.out.println("isArchive is " + attrDos.isArchive());
            System.out.println("isSystem is " + attrDos.isSystem());
        } catch (UnsupportedOperationException x) {
            System.err.println("DOS file" + " attributes not supported:" + x);
        }
    }
}
