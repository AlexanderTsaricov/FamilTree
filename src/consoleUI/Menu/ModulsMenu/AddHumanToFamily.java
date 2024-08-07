package consoleUI.Menu.ModulsMenu;
import Presenter.Presenter;
import java.util.Calendar;
import java.util.Scanner;

public class AddHumanToFamily implements MenuFunc {

    @Override
    public String getMenuItemName() {
        return "Добавить нового члена династии";
    }

    @Override
    public void use(Presenter presenter) {
        String[] FIO = new String[3];
        Scanner enter = new Scanner(System.in);
        System.out.println("1. Добавить с родителем\n2. Добавить без родителя");
        String strWithParentsOrNo = enter.nextLine();
        int withParentsOrNo = Integer.parseInt(strWithParentsOrNo);
        if (withParentsOrNo == 1) {
            System.out.println("Выберете родителя из списка:");
            System.out.println(presenter.getHumanList());
            System.out.print("Введите номер родителя: ");
            String parentIndexStr = enter.nextLine();
            int parentIndex = Integer.parseInt(parentIndexStr);
        }
        System.out.print("Введите ФИО или 1 для выхода: ");
        String inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
        } else {
            FIO = inputMessage.split(" ");
            System.out.println("Выберите пол или\n1. Мужской\n2. Женский\n---Любой другой текст: отмена");
            System.out.print("Введите цифру: ");
            inputMessage = enter.nextLine();
            if (!inputMessage.equals("1") || !inputMessage.equals("2")) {
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
            presenter.addHuman(FIO, alive, dateOfBirth, withParentsOrNo);
        }
    }
}
