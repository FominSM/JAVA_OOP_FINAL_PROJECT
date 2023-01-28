package View;
import java.util.List;


public class ContactsView {
    public void helloMessage(){
        StringBuilder startMessage = new StringBuilder()
            .append("\n ==== \n")
            .append("1 - Посмотреть список контрагентов\n")
            .append("2 - Найти контрагента по названию. Посмотреть подробную информацию о нём\n")
            .append("3 - Добавить контрагента\n")
            .append("0 - Выход\n")
            .append(" ==== \n");
        System.out.println(startMessage);
    }

    public void print(List<String> data) {
        System.out.println("\nСписок контактов:");
        int count = 1;
        for(String value: data) {
            System.out.printf("\t%d. %s\n", count++, value);
        }
    }

    public void mode2(List<String> data) {
        System.out.printf("\nАбонент - %s\nСпособы связи:\n", data.get(0));
        for(int i = 1; i < data.size(); i++){
            System.out.printf("\t%s\n", data.get(i));
        } 
    }
     
}
