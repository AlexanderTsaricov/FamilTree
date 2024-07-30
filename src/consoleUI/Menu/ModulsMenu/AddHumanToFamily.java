package consoleUI.Menu.ModulsMenu;
import Service.ServiceHumanFamily;
import java.util.Calendar;
import java.util.Scanner;

public class AddHumanToFamily implements MenuFunc {

    @Override
    public String getMenuItemName() {
        return "Добавить нового члена династии";
    }

    @Override
    public void use(ServiceHumanFamily service) {
        String[] FIO = new String[3];
        Scanner enter = new Scanner(System.in);
        System.out.println("1. Добавить с родителем\n2. Добавить без родителя");
        String strWithParentsOrNo = enter.nextLine();
        int withParentsOrNo = Integer.parseInt(strWithParentsOrNo);
        if (withParentsOrNo == 1) {
            System.out.println("Выберете родителя из списка:");
            for (int i = 0; i < service.getHumansList().size(); i++) {
                System.out.println(i + 1 + service.getHumansList().get(i).toString());
            }
            System.out.print("Введите номер родителя: ");
            String parentIndexStr = enter.nextLine();
            int parentIndex = Integer.parseInt(parentIndexStr);
            service.humanFromFamily = service.getHumansList().get(parentIndex - 1);
        }
        System.out.print("Введите ФИО или 1 для выхода: ");
        String inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
            return;
        } else {
            FIO = inputMessage.split(" ");
            System.out.println("Выберите пол или\n1. Мужской\n2. Женский\n---Любой другой текст: отмена");
            System.out.print("Введите цифру: ");
            inputMessage = enter.nextLine();
            if (inputMessage.equals("1")) {
                service.useSex = service.male;
            } else if (inputMessage.equals("2")) {
                service.useSex = service.female;
            } else {
                return;
            }
            System.out.println("Этот человек жив?\n1. Да\n2. Нет");
            inputMessage = enter.nextLine();
            boolean alive;
            if (inputMessage.equals("1")) {
                alive = true;
            } else {
                alive = false;
            }
            System.out.println("Введите дату рождения через запятую");
            System.out.println("Например: 5,2,1993");
            System.out.print("Дата: ");
            inputMessage = enter.nextLine();
            String[] temp = inputMessage.split(",");
            int[] date = new int[3];
            for (int i = 0; i < temp.length; i++) {
                date[i] = Integer.parseInt(temp[i]);
            }
            Calendar dateOfBirth = Calendar.getInstance();
            dateOfBirth.set(date[2], date[1], date[0]);
            service.newHuman(FIO[0], FIO[1], FIO[2], alive, dateOfBirth);
            service.addHuman();
            if (withParentsOrNo == 1) {
                service.setParent();
            }
        }
    }
}
