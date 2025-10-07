import java.util.*;

class Main{
    public static void main(String[] args){
        System.out.println(SingletonClass.getInstance().sayHello());
    }
}

class SingletonClass{
    private SingletonClass(){}
    private static SingletonClass obj = new SingletonClass();
    public static SingletonClass getInstance(){
        return obj;
    }
    String hello = "Hello";
    public String sayHello(){
        return this.hello;
    }
}
