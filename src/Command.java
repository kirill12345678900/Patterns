public class Command {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp), new StopCommand(comp), new ResetCommand(comp));
        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }
}

interface Commandd{
    void execute();
}

class Comp{
    void start(){
        System.out.println("Start");
    }

    void stop(){
        System.out.println("Stop");
    }

    void reset(){
        System.out.println("Reset");
    }
}

class StartCommand implements Commandd{

    Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Commandd{

    Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Commandd{

    Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

class User{
    Commandd start;
    Commandd stop;
    Commandd reset;

    public User(Commandd start, Commandd stop, Commandd reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer(){
        start.execute();
    }

    void stopComputer(){
        stop.execute();
    }

    void resetComputer(){
        reset.execute();
    }
}


