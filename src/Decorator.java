public class Decorator {
    public static void main(String[] args) {
        PrintInterface printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("Привет")));
        printer.print();
    }
}

interface PrintInterface{
    void print();
}

class Printer implements PrintInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class MyDecorator implements PrintInterface{
    PrintInterface component;

    public MyDecorator(PrintInterface component) {
        this.component = component;
    }

    public void print(){
        component.print();
    }
}

class LeftBracketDecorator extends MyDecorator{
    public LeftBracketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends MyDecorator{

    public RightBracketDecorator(PrintInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}