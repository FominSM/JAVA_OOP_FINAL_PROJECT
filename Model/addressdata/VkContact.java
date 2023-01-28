package Model.addressdata;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VkContact extends Contact{
    private String vkAdress;
    Scanner in = new Scanner(System.in);

    public VkContact() {
        this.vkAdress = addContactMethod();
        this.dataContact =  vkAdress;
    }

    @Override
    protected String addContactMethod() {
        while(true){
            System.out.print("Введите адресс страницы VK в формате https://vk.com/id123456: ");
        
            try {
                vkAdress = in.nextLine();
                if(dataValidation()){
                    System.out.println("\nАдресс страницы VK добавлен!");
                    return vkAdress;
                }
                else System.out.println("Повторите попытку снова.");
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неккоректное значение");           
            }
        }    
    }

    @Override
    public boolean dataValidation() {
        String[] arr = vkAdress.split("id");
        if(arr[0].equals("https://vk.com/"))
            if(arr[1].length() == 6 && Integer.parseInt(arr[1]) > 0)
                return true; 
        return false; 
    }
}
