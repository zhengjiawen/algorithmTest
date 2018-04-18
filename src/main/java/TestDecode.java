package main.java;

public class TestDecode {

    public static void main(String[] args){
        String name = "hello world";
        byte[] bytes = name.getBytes();

        String result = new String(bytes);

        System.out.println(result);
    }
}
