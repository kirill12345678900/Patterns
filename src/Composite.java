import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();

        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composites composites = new Composites();
        Composites composites1 = new Composites();
        Composites composites2 = new Composites();

        composites1.addComponent(square1);
        composites1.addComponent(square2);
        composites1.addComponent(triangle1);

        composites2.addComponent(square3);
        composites2.addComponent(circle1);
        composites2.addComponent(circle2);
        composites2.addComponent(circle3);

        composites.addComponent(composites1);
        composites.addComponent(composites2);

        composites.draw();
    }
}

interface Shape{
    void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Привет, я квадрат");
    }
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Привет, я треугольник");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Привет, я круг");
    }
}

class Composites implements Shape{
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }

    public void removeComponent(Shape component){
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component: components) {
            component.draw();
        }
    }
}
