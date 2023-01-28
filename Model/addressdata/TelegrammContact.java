package Model.addressdata;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TelegrammContact extends Contact{
    private String telegramName;
    Scanner in = new Scanner(System.in);

    public TelegrammContact() {
        this.telegramName = addContactMethod();
        this.dataContact =  telegramName;
    }

    @Override
    protected String addContactMethod() {
        while(true){
            System.out.print("Введите ник telegramm в формате @xxxxxx : ");
        
            try {
                telegramName = in.nextLine();
                if(dataValidation()){
                    System.out.println("\nНик telegramm добавлен!");
                    return telegramName;
                }
                else System.out.println("Повторите попытку снова.");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");           
            }
        }    
    }

    @Override
    public boolean dataValidation() {
        if(telegramName.charAt(0) == '@') return true; 
        return false; 
    }
}
