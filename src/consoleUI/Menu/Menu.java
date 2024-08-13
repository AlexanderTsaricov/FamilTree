package consoleUI.Menu;

import Presenter.Presenter;
import Service.ModulsService.human.Sex;
import consoleUI.Menu.ModulsMenu.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
    private ArrayList<MenuFunc> comands = new ArrayList<>();
    private Presenter presenter;
    private boolean flag = true;
    // Данное поле нужно для флага, который находится внутри модуля OutOfProgram

    public Menu() throws IOException, ClassNotFoundException {
        presenter = new Presenter();
    }

    public void start() throws IOException {

        this.comands.add(new AddHumanToFamily());
        this.comands.add(new AddFamilyConnection());
        this.comands.add(new PrintDinasty());
        this.comands.add(new PrintFamilyList());
        this.comands.add(new PrintOldestHuman());
        this.comands.add(new PrintYongestHuman());
        this.comands.add(new OutOfProgram());

        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.comands.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(this.comands.get(i).getMenuItemName());
            sb.append("\n");
        }
        while (flag) {
            if (!presenter.getErrorMessage().equals("")) {
                System.out.println(presenter.getErrorMessage());
            }
            System.out.println("Меню:");
            System.out.println(sb.toString());
            String choice = scanner.nextLine();
            int index = Integer.parseInt(choice) - 1;
            if (index < 0 || index >= this.comands.size()) {
                System.out.println("Неправильный ввод. Попробуйте еще раз.");
                continue;
            }
            this.comands.get(index).use(this);
        }
    }

    public void addConnectionPeople() {
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
    public void addPeople() {
        int parentIndex = 0;
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
            parentIndex = Integer.parseInt(parentIndexStr) - 1;
        }
        System.out.print("Введите ФИО или 1 для выхода: ");
        String inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
        } else {
            FIO = inputMessage.split(" ");
            System.out.println("Выберите пол или\n1. Мужской\n2. Женский\n---Любой другой текст: отмена");
            Sex sex;
            System.out.print("Введите цифру: ");
            inputMessage = enter.nextLine();
            if (!inputMessage.equals("1") && !inputMessage.equals("2")) {
                return;
            } else if (inputMessage.equals("1")) {
                sex = Sex.Male;
            } else {
                sex = Sex.Female;
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
            presenter.addHuman(FIO, sex, alive, dateOfBirth, withParentsOrNo, parentIndex);
        }
    }
    public void out() throws IOException {
        presenter.saveFamily();
        flag = false;
        System.out.println("Выход из программы");
    }
    public void printDinasty() {
        System.out.println(presenter.getDytansy());
    }
    public void printDinastyToList() {
        System.out.println("Сортировка по:\n1. Имени\n2. Возрасту\nЛюбое другое значение: Без сортировки");
        Scanner enter = new Scanner(System.in);
        String typeSort = enter.nextLine();
        presenter.sort(typeSort);
        System.out.println(presenter.getHumanList());
    }
    public void printOldestPeople() {
        if (presenter.boolStateDynasty()) {
            System.out.println(presenter.getOldestHuman());
        } else {
            System.out.println(presenter.stateDynasty());
        }
    }
    public void printYoungestPeople() {
        if (presenter.boolStateDynasty()) {
            System.out.println(presenter.getYoungestHuman());
        } else {
            System.out.println(presenter.stateDynasty());
        }
    }
}
