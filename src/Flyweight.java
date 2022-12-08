import java.util.*;

public class Flyweight {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shapee> shapes = new ArrayList<>();
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));

        Random random = new Random();

        for (Shapee shape: shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x,y);
        }
    }
}

interface Shapee{
    void draw(int x, int y);
}

class Point implements Shapee{

    @Override
    public void draw(int x, int y) {
        System.out.println(x + " , " + y + ": рисуем точку");
    }
}

class Circlee implements Shapee{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println(x + " , " + y + ": рисуем круг с радиусом " + r);
    }
}
class Squaree implements Shapee{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println(x + " , " + y + ": рисуем квадрат со стороной " + a);
    }
}

class ShapeFactory{
    private static final Map<String, Shapee> shapes = new HashMap<>();

    public Shapee getShape(String shapeName){

        Shapee shape = shapes.get(shapeName);
        if(shape == null){
            switch (shapeName){
                case "круг":
                    shape = new Circlee();
                    break;
                case "квадрат":
                    shape = new Squaree();
                    break;
                case "точка":
                    shape = new Point();
                    break;

            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}