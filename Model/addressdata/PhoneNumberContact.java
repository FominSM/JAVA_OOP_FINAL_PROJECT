package Model.addressdata;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneNumberContact extends Contact{
    private String number;
    Scanner in = new Scanner(System.in);

    public PhoneNumberContact() {
        this.number = addContactMethod();
        this.dataContact =  number;
    }

    @Override
    protected String addContactMethod() {
        while(true){
            System.out.print("Введите 11-и значный номер, начиная с 8(без пробелов и знаков): ");
        
            try {
                number = in.nextLine();
                if(dataValidation()){
                    System.out.println("\nНомер добавлен!");
                    return number;
                }
                else System.out.println("Повторите попытку снова.");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");           
            }
        }    
    }

    @Override
    public boolean dataValidation() {
        if(number.length() == 11 && number.matches("^[0-9]*$")) return true; 
        return false; 
    }  
}
