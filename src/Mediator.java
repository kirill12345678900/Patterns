import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public static void main(String[] args) {

        TextChat chat = new TextChat();

        Userr admin = new Admin(chat);
        Userr u1 = new SimpleUser(chat);
        Userr u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("Hello, i'm gay!");
        //admin.sendMessage("Admin! No, i'm gay!");
    }
}

interface Userr {
    void sendMessage(String message);
    void getMessage(String message);
}

interface Chat {
    void sendMessage(String message, Userr user);
}

class TextChat implements Chat{
    Userr admin;

    List<Userr> users = new ArrayList<>();

    public void setAdmin(Userr admin) {
        this.admin = admin;
    }

    public void addUser(Userr u){
        users.add(u);
    }

    @Override
    public void sendMessage(String message, Userr user) {
        for (Userr u: users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}

class Admin implements Userr {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin getting message: " + message + "'");
    }
}

class SimpleUser implements Userr {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User getting message: " + message + "'");
    }
}


