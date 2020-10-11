package _1_Jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        Jar<Integer> jarTwo = new Jar<>();

        jar.add("Pesho");
        jarTwo.add(13);

        System.out.println(jar.remove());
    }
}