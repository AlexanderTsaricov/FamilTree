import human.Human;
import human.Sex;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        try {
            tree = tree.load();

        } catch (IOException e){
            System.out.println(e.getMessage() + " - Не получилось загрузить семью");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        startProgram(tree);
    }
    public static void startProgram(FamilyTree tree) throws IOException {
        String message = """
                1. Показать старшего династии
                2. Показать младшего династии
                3. Добавить человека
                4. Добавить кровную линию
                5. Показать дерево династии
                6. Показать список людей
                7. Выход
                """;
        Scanner enter = new Scanner(System.in);

        while (true) {
            System.out.println(message);
            int inputMessage = enter.nextInt();
            if (inputMessage == 7) {
                System.out.println("Сохранение...");
                tree.save();
                System.exit(0);
            }
            switch (inputMessage) {
                case 1:
                    if (tree.getHumanList().size() < 1) {
                        System.out.println("Династия пуста");
                    } else {
                        System.out.println(tree.getOldestHuman());
                    }
                    break;
                case 2:
                    if (tree.getHumanList().size() < 1) {
                        System.out.println("Династия пуста");
                    } else {
                        System.out.println(tree.geYoungestHuman());
                    }
                    break;
                case 3:
                    addHuman(tree);
                    break;
                case 4:
                    addBloodline(tree);
                    break;
                case 5:
                    if (tree.getHumanList().size() > 0) {
                        Human oldestHuman = tree.getOldestHuman();
                        printDinasty(oldestHuman);
                    } else {
                        System.out.println("Дерево пустое");
                    }
                    break;
                case 6:
                    for (int i = 0; i < tree.getHumanList().size(); i++) {
                        System.out.println(tree.getHumanList().get(i));
                    }
            }
        }
    }

    public static void addHuman(FamilyTree tree) throws IOException {
        String[] FIO = new String[3];
        Scanner enter = new Scanner(System.in);
        System.out.print("Введите ФИО или 1 для выхода: ");
        String inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
            return;
        } else {
            FIO = inputMessage.split(" ");
        }
        Sex sex = Sex.Male;
        System.out.println("Выберите пол или\n1. Мужской\n2. Женский\nЛюбой другой текст: отмена");
        System.out.print("Введите цифру: ");
        inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
            sex = Sex.Male;
        } else if (inputMessage.equals("2")) {
            sex = Sex.Female;
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
        Human human = new Human(FIO[0], FIO[1], FIO[2], sex, alive, dateOfBirth);
        tree.addHuman(human);
    }
    public static void printAllHumans(FamilyTree tree) {
        for (int i = 0; i < tree.getHumanList().size(); i++) {
            System.out.println(i + ". " + tree.getHumanList().get(i));
        }
    }
    public static void addBloodline(FamilyTree tree) {
        if (tree.getHumanList().size() < 1) {
            System.out.println("Династия пуста");
        } else {
            System.out.println("Выберете человека из списка:");
            printAllHumans(tree);
            Scanner enter = new Scanner(System.in);
            int inputMessage = enter.nextInt();
            Human human = tree.getHumanList().get(inputMessage);
            System.out.println("1. Добавить родителя\n2. Добавить дитя\nДобавить мужа(жену)");
            inputMessage = enter.nextInt();
            int valueBlood = inputMessage;
            System.out.println("Выберете человека из списка:");
            printAllHumans(tree);
            inputMessage = enter.nextInt();
            Human bloodlineHuman = tree.getHumanList().get(inputMessage);
            switch (valueBlood) {
                case 1:
                    Human.setParent(bloodlineHuman, human);
                    break;
                case 2:
                    Human.setChild(human, bloodlineHuman);
                    break;
                case 3:
                    Human.setSpouse(human, bloodlineHuman);
                    break;
            }
        }
    }
    public static void printDinasty(Human human) {
        int indent = 1;
        String sIndent = "    ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + sIndent;
        }
        ArrayList<Human> childnrens = human.getChildrens();
        System.out.println(human);
        System.out.println(sIndent + "Дети:");
        indent+=1;
        for (int i = 0; i < childnrens.size(); i++) {
            printDinasty(childnrens.get(i), indent);
        }
    }
    public static void printDinasty(Human human, int indent) {
        String sIndent = "    ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + sIndent;
        }
        ArrayList<Human> childnrens = human.getChildrens();
        if (human.getSpouse() != null) {
            System.out.println(sIndent + human + " супруг/га: " + human.getSpouse());
        } else {
            System.out.println(sIndent + human);
        }
        if (human.getChildrens().size() > 0) {
            System.out.println(sIndent + sIndent + "Дети:");
            indent += 1;
            for (int i = 0; i < childnrens.size(); i++) {
                printDinasty(childnrens.get(i));
            }
        }
    }
}