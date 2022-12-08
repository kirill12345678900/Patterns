public class Visitorr {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visisor hooligan = new HooliganVisitor();

        body.accept(hooligan);
        engine.accept(hooligan);
    }
}

interface Visisor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
}

interface Element{
    void accept(Visisor visisor);
}

class BodyElement implements Element{

    @Override
    public void accept(Visisor visisor) {
        visisor.visit(this);
    }
}

class EngineElement implements Element{

    @Override
    public void accept(Visisor visisor) {
        visisor.visit(this);
    }
}

class HooliganVisitor implements Visisor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завёл двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }
}

class MechanicVisitor implements Visisor{

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал кузов");
    }
}
