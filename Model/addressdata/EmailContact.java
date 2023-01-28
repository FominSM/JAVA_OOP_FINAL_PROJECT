package Model.addressdata;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailContact extends Contact{
    private String email;
    Scanner in = new Scanner(System.in);

    public EmailContact() {
        this.email = addContactMethod();
        this.dataContact =  email;
    }

    @Override
    protected String addContactMethod() {
        while(true){
            System.out.print("Введите email в вормате xxxxxx@mail.ru : ");
        
            try {
                email = in.nextLine();
                if(dataValidation()){
                    System.out.println("\nEmail добавлен!");
                    return email;
                }
                else System.out.println("Повторите попытку снова.");

            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");           
            }
        }
          
    }

    @Override
    public boolean dataValidation() {
        if(email.contains("@mail.ru")) return true; 
        return false; 
    }

}
