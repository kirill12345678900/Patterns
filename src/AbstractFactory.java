import java.security.Key;

public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse mouse = factory.getMouse();
        KeyBoard keyBoard = factory.getKeyBoard();
        TouchPad touchPad = factory.getTouchPad();

        mouse.click();
        keyBoard.print();
        keyBoard.println();
        touchPad.track(10,35);
    }

    private static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RusDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Нет такой страны" + lang);
        }
    }
}



interface Mouse{
    void click();
    void dblclick();
    void scroll(int direction);
}

interface KeyBoard{
    void print();
    void println();
}

interface TouchPad{
    void track(int deltaX, int deltaY);
}

interface DeviceFactory{
    Mouse getMouse();
    KeyBoard getKeyBoard();
    TouchPad getTouchPad();
}

class RusMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dblclick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if(direction > 0){
            System.out.println("Скроллим вверх");
        } else if (direction < 0) {
            System.out.println("Скроллим вниз");
        }else {
            System.out.println("Не скроллим");
        }
    }
}

class RusKeyBoard implements KeyBoard{
    @Override
    public void print() {
        System.out.println("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переходом на новую");
    }
}

class RusTouchPad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
        System.out.println("Передвинулись на" + s + "пикселей");
    }
}

/////////

class EnMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dblclick() {
        System.out.println("Double mouse click");
    }

    @Override
    public void scroll(int direction) {
        if(direction > 0){
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        }else {
            System.out.println("No scrolling");
        }
    }
}

class EnKeyBoard implements KeyBoard{
    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print line");
    }
}

class EnTouchPad implements TouchPad{
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY,2));
        System.out.println("Moved" + s + "pixels");
    }
}

class EnDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new EnKeyBoard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}

class RusDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new RusMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new RusKeyBoard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RusTouchPad();
    }
}

