import Presenter.*;
import View.*;
import Model.*;

class Main{
    public static void main(String[] args) {
        new Controller(new ContactService(), new ContactsView()).start();   
    }
}