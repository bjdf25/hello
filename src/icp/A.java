package icp;

public class A {
    public int getNumber(int a ){
        return a+1;
    }
}
 class C{
    public int getNumber(int a ){
        return  a+1;
    }
}
class B extends A{
    @Override
    public int getNumber(int a) {
        return super.getNumber(a);
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getNumber(10));
        B b = new B();
        System.out.println(b.getNumber(10));
    }
}

