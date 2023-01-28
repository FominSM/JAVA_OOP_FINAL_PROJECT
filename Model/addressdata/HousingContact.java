package Model.addressdata;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HousingContact extends Contact{
    private String address;
    Scanner in = new Scanner(System.in);
    
    public HousingContact() {
        this.address = addContactMethod();
        this.dataContact =  address;
    }

    @Override
    protected String addContactMethod() {
        while(true){
            System.out.print("Введите адресс проживания : ");
        
            try {
                address = in.nextLine();
                if(dataValidation()){
                    System.out.println("\nАдресс проживания добавлен!");
                    return address;
                }
                else System.out.println("Повторите попытку снова.");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");           
            }
        }    
    }

    @Override
    public boolean dataValidation() {
        if(address != null) return true; 
        return false; 
    }
}
