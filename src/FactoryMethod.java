import java.util.Date;

public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker maker = new DigitalWatchMaker();
       // WatchMaker maker = getMakerByName("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        if(maker.equals("Digital")){
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }else {
            throw new RuntimeException("Нету таких часов" + maker);
        }
    }
}


interface Watch{ //product
    void showTime();
}

class DigitalWatch implements Watch { // конкретный продукт
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("Римское время");
    }
}

interface WatchMaker{ //factory method
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
