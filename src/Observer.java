import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());

        station.setMeasurements(25,750);
    }
}

interface Observed {
    void addObserver(Observerr o);

    void removeObserver(Observerr o);

    void notifyObserve();
}

interface Observerr {
    void handleEvent(int temp, int presser);
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;

    List<Observerr> observers = new ArrayList<>();

    public void setMeasurements(int x, int p){
        temperature = x;
        pressure = p;
        notifyObserve();
    }


    @Override
    public void addObserver(Observerr o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observerr o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserve() {
        for (Observerr o: observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observerr{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("Погода изменилась. Температура = " + temp + " , Давление = " + presser + ".");
    }
}

