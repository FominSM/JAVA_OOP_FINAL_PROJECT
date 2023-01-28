package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Model.addressdata.*;
import Model.contacts.*;;


public class ContactService {
    private List<Subscriber> phoneBook;
    private StringBuilder listOfCommunicationModes;
    private StringBuilder editMessage;

    Scanner in = new Scanner(System.in);

    public ContactService() {
        this.listOfCommunicationModes = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - Добавить телефон\n")
                .append("2 - Добавить email\n")
                .append("3 - Добавить ник в telegram\n")
                .append("4 - Добавить адрес страницы VK\n")
                .append("5 - Добавить уличный адрес\n")
                .append("0 - Вернуться в главное меню\n")
                .append(" ==== ");

        this.editMessage = new StringBuilder()
            .append("\nВыберите нужную функцию: \n")
            .append("1 - Удалить контрагента\n")
            .append("2 - Добавить новый способ связаться с контрагентом\n")
            .append("3 - Удалить способ связаться с контрагентом\n")
            .append("0 - Выход\n")
            .append("Введите номер: ");

        this.phoneBook = new ArrayList<>();
 
    }

    public void addNewContact(){
        String name = new String();
        int modeData = -1;
        Boolean flagName = true;
        Boolean flagCommunicationMethods = true;

        while(flagName){
            System.out.print("Введите ФИ(название) контакта(компании): ");
            try{
                name = in.next();
                if(checkCorrectnessName(name))
                    flagName = false;
                else
                    System.out.println("Введенное ФИ(Название) неккоректно, повторите операцию");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");            
            }
        }

        Subscriber newContact = new Subscriber(name);
    
        while(flagCommunicationMethods){
            System.out.println(listOfCommunicationModes);
            System.out.print("Выберите режим: ");

            try{ modeData = in.nextInt(); } 
            catch (NumberFormatException e) { 
                System.out.println("Вы ввели неккоректное значение"); 
            }

            switch (modeData) {
                case 1:
                    newContact.getCommunicationMethods().add(new PhoneNumberContact());
                    break;
                case 2:
                    newContact.getCommunicationMethods().add(new EmailContact());
                    break;
                case 3:
                    newContact.getCommunicationMethods().add(new TelegrammContact());
                    break;
                case 4:
                    newContact.getCommunicationMethods().add(new VkContact());
                    break;
                case 5:
                    newContact.getCommunicationMethods().add(new HousingContact());
                    break;
                case 0:
                    System.out.printf("\n%s добавлен в телефонную книгу!\n", name);
                    phoneBook.add(newContact);
                    flagCommunicationMethods = false;           
            }

        }
    }

    // сканер русских букв 
    private boolean checkCorrectnessName(String value){
        return value != null && value.matches("^[a-zA-Z]*$");
    }

    public List<String> contactSearch() {
        List<String> contactСard = new ArrayList<>();
        String searchName = new String();
        Boolean searcFlag = true;

        while(searcFlag){
            System.out.print("Введите имя контакта: ");
            try{ 
                searchName = in.nextLine();
                for(Subscriber subscriber : phoneBook){
                    if(subscriber.getName().equals(searchName)){
                        contactСard.add(searchName);
                        for(Contact metod: subscriber.getCommunicationMethods()){
                            contactСard.add(metod.getData());
                        }
                        searcFlag = false;
                    }
                }
            } 
            catch (InputMismatchException e) { 
                System.out.println("Вы ввели неккоректное значение"); 
            }
        }
        if(contactСard.size() == 0){
            System.out.println("Такого контакта нет.");
            return null;
        }
        return contactСard;
    }

    public void editSubscriber(String name){
        String editMode = new String();
        Boolean editFlag = true;        

        for(int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(i).getName().equals(name)){
                while(editFlag){
                    System.out.print(editMessage);
                    try{editMode = in.nextLine(); } 
                    catch (InputMismatchException e) { 
                        System.out.println("Вы ввели неккоректное значение");
                        break; 
                    }
                    switch (editMode) {
                        case "1":
                            phoneBook.remove(i);
                            System.out.printf("\n%s, удален !\n", name);
                            editFlag = false;
                            break;
                        case "2":
                            System.out.println(listOfCommunicationModes);
                            String  mode2 = new String();
                            System.out.print("Выберите режим: ");
                
                            try{ mode2 = in.nextLine(); } 
                            catch (NumberFormatException e) { 
                                System.out.println("Вы ввели неккоректное значение");
                                break; 
                            }
                            switch (mode2) {
                                case "1":
                                    phoneBook.get(i).getCommunicationMethods().add(new PhoneNumberContact());
                                    break;
                                case "2":
                                    phoneBook.get(i).getCommunicationMethods().add(new EmailContact());
                                    break;
                                case "3":
                                    phoneBook.get(i).getCommunicationMethods().add(new TelegrammContact());
                                    break;
                                case "4":
                                    phoneBook.get(i).getCommunicationMethods().add(new VkContact());
                                    break;
                                case "5":
                                    phoneBook.get(i).getCommunicationMethods().add(new HousingContact());
                                    break;
                                case "0":
                                    break;           
                            }
                            break;
                        case "3":
                            int count = 1; 
                            int mode3;
                            System.out.printf("\nСпособы связи с контактом %s:\n", name);
                            for(Contact data : phoneBook.get(i).getCommunicationMethods()){
                                System.out.printf("%d - %s \n", count,  data.getData());
                                count++;
                            }
                            System.out.print("Введите цифру способа, который хотите удалить: ");

                            try{
                                mode3 = in.nextInt();
                                if(mode3-1 <= phoneBook.get(i).getCommunicationMethods().size() - 1){
                                    phoneBook.get(i).getCommunicationMethods().remove(mode3-1);
                                    System.out.println("\nCпособ связи удален!");
                                    break;
                                }
                            } 
                            catch (InputMismatchException e) { 
                                System.out.println("Вы ввели неккоректное значение");
                                break; 
                            }
                        case "0":
                            System.out.printf("\n%s, отредактирован !\n", name);
                            editFlag = false;
                            break;
                    }        
                }
            }
        }
   
    }

    public int getSizePhoneBook() {
        return phoneBook.size();
    }

    public List<String> getNameContact(){
        List<String> listName = new ArrayList<String>();
        for(Subscriber subscriber: phoneBook)
            listName.add(subscriber.getName());
        return listName;
    }
}
