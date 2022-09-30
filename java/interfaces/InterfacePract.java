package sarbajit.interfaces;

interface Test{
    void meth1();
    void meth2();
}

class MyTest implements Test{
    public void meth1(){
        System.out.println("Meth1 of class MyTest");
    }
    public void meth2(){
        System.out.println("Meth2 of class MyTest");
    }
    public void meth3(){
        System.out.println("Meth1 of class MyTest");
    }
}

public class InterfacePract {
    public static void main(String[] args) {
        Test t = new MyTest();
        t.meth1();
        t.meth2();
    }
}
