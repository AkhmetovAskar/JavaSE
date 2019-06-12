package javase.sandbox;

public class Sandbox {
    public static void main(String[] args) {
        String str = "Askar;";
        String[] arr = str.split(";");
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
