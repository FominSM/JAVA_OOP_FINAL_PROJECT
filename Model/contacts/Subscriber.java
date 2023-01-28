package Model.contacts;
import java.util.ArrayList;
import java.util.List;
import Model.addressdata.*;

public class Subscriber {
    private String name;
    private List<Contact> communicationMethods;

    public Subscriber(String name) {
        this.name = name;
        this.communicationMethods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Contact> getCommunicationMethods() {
        return communicationMethods;
    }    
}
