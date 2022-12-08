public class TemplateMethod {
    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();

        C c = new B();
        c.templateMethod();
    }
}

abstract class C{
    void templateMethod(){
        System.out.println("1");
        differ();
        System.out.println("3");
        differ2();
    }

    abstract void differ2();

    abstract void differ();
}

class A extends C{

    @Override
    void differ2() {
        System.out.println("5");
    }

    @Override
    void differ() {
        System.out.println("2");
    }
}

class B extends C{
    @Override
    void differ2() {

    }

    @Override
    void differ() {
        System.out.println("4");
    }
}


