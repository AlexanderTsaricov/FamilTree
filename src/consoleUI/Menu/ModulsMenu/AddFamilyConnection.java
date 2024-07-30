package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

import java.util.Scanner;

public class AddFamilyConnection implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Добавить фамильную связь";
    }

    @Override
    public void use(ServiceHumanFamily service) {
        if (service.getHumansList().size() < 1) {
            System.out.println("Династия пуста");
        } else {
            System.out.println("Выберете человека из списка:");
            for (int i = 0; i < service.getHumansList().size(); i++) {
                System.out.println(i + 1 + ". " + service.getHumansList().get(i).toString());
            }
            Scanner enter = new Scanner(System.in);
            String inputMessageStr = enter.nextLine();
            int inputMessage = Integer.parseInt(inputMessageStr) - 1;
            service.human = service.getHumansList().get(inputMessage);
            System.out.println("1. Добавить родителя\n2. Добавить дитя\n3. Добавить мужа(жену)");
            String valueBlood = enter.nextLine();
            System.out.println("Выберете человека из списка:");
            for (int i = 0; i < service.getHumansList().size(); i++) {
                System.out.println(i + 1 + ". " + service.getHumansList().get(i).toString());
            }
            inputMessageStr = enter.nextLine();
            inputMessage = Integer.parseInt(inputMessageStr) - 1;
            service.humanFromFamily = service.getHumansList().get(inputMessage);
            boolean flag = true;
            while (flag) {
                switch (valueBlood) {
                    case "1":
                        service.setParent();
                        flag = false;
                        break;
                    case "2":
                        service.setChild();
                        flag = false;
                        break;
                    case "3":
                        flag = false;
                        service.setSpouse();
                        break;
                    default:
                        System.out.println("Неверный ввод");
                        break;
                }
            }
        }
    }
}
