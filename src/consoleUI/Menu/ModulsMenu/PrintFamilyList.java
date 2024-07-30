package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

import java.util.Scanner;

public class PrintFamilyList implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать династию списком";
    }

    @Override
    public void use(ServiceHumanFamily service) {
        System.out.println("Сортировка по:\n1. Имени\n2. Возрасту\nЛюбое другое значение: Без сортировки");
        Scanner enter = new Scanner(System.in);
        String inputMessageStr = enter.nextLine();
        if (inputMessageStr.equals("2")) {
            service.sortByAge();
        } else if (inputMessageStr.equals("1")) {
            service.sortByName();
        }
        for (int i = 0; i < service.getHumansList().size(); i++) {
            System.out.println(service.getHumansList().get(i));
        }
    }
}
