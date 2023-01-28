package Presenter;
import java.util.*;
import Model.*;
import View.ContactsView;


public class Controller {
    private ContactService model;
    private ContactsView view;
    Scanner in = new Scanner(System.in);

    public Controller(ContactService model, ContactsView view) {
        this.model = model;
        this.view = view;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        String modeNumber = new String();
         
        while(true){
            try {
                view.helloMessage();
                System.out.print("Выберите режим работы: ");
                modeNumber = in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");            
            }
        
            switch (modeNumber) {
                case "1":
                    if(model.getSizePhoneBook() == 0){
                        System.out.println("\nТелефонная книга еще пуста");
                        break;
                    }
                    else {
                        view.print(model.getNameContact());
                        break;
                    }
                case "2":
                    if(model.getSizePhoneBook() == 0){
                        System.out.println("\nТелефонная книга еще пуста");
                        break;
                    }
                    else {
                        List<String> arr = model.contactSearch();
                        if(arr != null)
                            view.mode2(arr);
                            model.editSubscriber(arr.get(0));
                        break;                  
                    }
                case "3":
                    model.addNewContact();
                    break;
                case "0":
                    in.close();
                    System.out.println();
                    return;
            }
        }  
    }    
}
