package consoleUI.Menu.ModulsMenu;
import Presenter.Presenter;

import java.util.Scanner;

public class AddFamilyConnection implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Добавить фамильную связь";
    }

    @Override
    public void use(Presenter presenter) {
        if (presenter.boolStateDynasty()) {
            System.out.println(presenter.stateDynasty());
        } else {
            System.out.println(presenter.stateDynasty());
            System.out.println("Выберете человека из списка:");

            Scanner enter = new Scanner(System.in);
            String inputMessageStr = enter.nextLine();
            int human = Integer.parseInt(inputMessageStr) - 1;
            //
            System.out.println("1. Добавить родителя\n2. Добавить дитя\n3. Добавить мужа(жену)");
            String typeConnection = enter.nextLine();
            System.out.println("Выберете человека из списка:");
            System.out.println(presenter.getHumanList());
            inputMessageStr = enter.nextLine();
            int connectHuman = Integer.parseInt(inputMessageStr) - 1;
            //
            boolean flag = true;
            while (flag) {
                switch (typeConnection) {
                    case "1":
                    case "2":
                    case "3":
                        presenter.setBloodLine(typeConnection, human, connectHuman);
                        flag = false;
                        break;
                    default:
                        System.out.println("Неверный ввод");
                        break;
                }
            }
        }
    }
}
