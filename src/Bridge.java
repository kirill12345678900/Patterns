public class Bridge {
    public static void main(String[] args) {
        Carr c = new Sedan(new Kia());
        c.showDetails();
    }
}

abstract class Carr {
    Make make;

    public Carr(Make n) {
        make = n;
    }

    abstract void showDetails();
}

class Sedan extends Carr {

    public Sedan(Make n) {
        super(n);
    }

    @Override
    void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}

class HatchBack extends Carr {

    public HatchBack(Make n) {
        super(n);
    }

    @Override
    void showDetails() {
        System.out.println("HatchBack");
        make.setMake();
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}


