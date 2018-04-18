package main.java;

public class TestDemo {
    public static void main(String[] args){
        A a = new A();
        A b = new B();
        a.print();
        b.print();
    }
}

class A{
    public void print(){
        System.out.println("a");
    }
}

class B extends A{
    @Override
    public void print(){
        System.out.println("b");
    }
}