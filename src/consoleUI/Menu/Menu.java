package consoleUI.Menu;

import Service.ServiceHumanFamily;
import consoleUI.Menu.ModulsMenu.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<MenuFunc> menu = new ArrayList<>();
    ServiceHumanFamily service;

    AddHumanToFamily addHuman = new AddHumanToFamily();
    AddFamilyConnection addFamilyConnection = new AddFamilyConnection();
    PrintDinasty printDinasty = new PrintDinasty();
    PrintFamilyList printFamilyList = new PrintFamilyList();
    PrintOldestHuman printOldest = new PrintOldestHuman();
    PrintYongestHuman printYoungest = new PrintYongestHuman();
    OutOfProgram out = new OutOfProgram();

    public Menu() throws IOException, ClassNotFoundException {
        service = new ServiceHumanFamily();
        this.menu.add(addHuman);
        this.menu.add(addFamilyConnection);
        this.menu.add(printDinasty);
        this.menu.add(printFamilyList);
        this.menu.add(printOldest);
        this.menu.add(printYoungest);
        this.menu.add(out);
    }

    public void start() throws IOException {

        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.menu.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(this.menu.get(i).getMenuItemName());
            sb.append("\n");
        }
        while (out.flag) {
            System.out.println(service.ERROR);
            System.out.println("Меню:");
            System.out.println(sb.toString());
            String choice = scanner.nextLine();
            int index = Integer.parseInt(choice) - 1;
            if (index < 0 || index >= this.menu.size()) {
                System.out.println("Неправильный ввод. Попробуйте еще раз.");
                continue;
            }
            this.menu.get(index).use(service);
        }
    }


}
