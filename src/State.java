public class State {
    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}

interface Station{
    void play();
}

class Radio7 implements Station{

    @Override
    public void play() {
        System.out.println("Радио 7...");
    }
}


class RadioDFM implements Station{

    @Override
    public void play() {
        System.out.println("Радио DFM ...");
    }
}

class VestFM implements Station{

    @Override
    public void play() {
        System.out.println("Вести FM ...");
    }
}

class Radio{
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestFM());
        } else if (station instanceof VestFM) {
            setStation(new Radio7());
        }
    }

    void play(){
        station.play();
    }
}

