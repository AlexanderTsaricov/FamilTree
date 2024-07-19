import human.Human;
import human.Sex;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Хотел добавить работу с JSON но не разобрался как это сделать
        Human alexander = new Human("Винокуров", "Александр", "Юрьевич", Sex.Male, true);
        alexander.setBirthDay(1993, 2, 5);
        Human antonina = new Human("Винокурова", "Антонина", "Юрьевна", Sex.Female, true);
        antonina.setBirthDay(1990, 7, 16);
        Human tatyana = new Human("Винокурова", "Татьяна", "Владимировна", Sex.Female, true);
        tatyana.setBirthDay(1961, 9, 4);
        Human.setChild(tatyana, alexander);
        Human.setChild(tatyana, antonina);
        Human sveta = new Human("Винокурова", "Светлана", "Олеговна", Sex.Female, true);
        sveta.setBirthDay(1994, 7, 13);
        Human.setSpouse(sveta, alexander);
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(alexander);
        humans.add(antonina);
        humans.add(tatyana);
        startProgram(humans);
    }
    public static void startProgram(ArrayList<Human> humans) {
        String message = """
                1. Показать старшего династии
                2. Показать младшего династии
                3. Добавить человека
                4. Добавить кровную линию
                5. Показать дерево династии
                6. Выход
                """;
        Scanner enter = new Scanner(System.in);

        while (true) {
            System.out.println(message);
            int inputMessage = enter.nextInt();
            if (inputMessage == 6) {
                System.exit(0);
            }
            switch (inputMessage) {
                case 1:
                    if (humans.size() < 1) {
                        System.out.println("Династия пуста");
                    } else {
                        System.out.println(getOldestHuman(humans));
                    }
                    break;
                case 2:
                    if (humans.size() < 1) {
                        System.out.println("Династия пуста");
                    } else {
                        System.out.println(geYoungestHuman(humans));
                    }
                    break;
                case 3:
                    addHuman(humans);
                    break;
                case 4:
                    addBloodline(humans);
                    break;
                case 5:
                    Human oldestHuman = getOldestHuman(humans);
                    printDinasty(oldestHuman);
                    break;
            }
        }
    }
    public static Human getOldestHuman (ArrayList<Human> humans) {
        Human oldestHuman = humans.get(0);
        for (int i = 1; i < humans.size(); i++) {
            if (humans.get(i).getAge() > oldestHuman.getAge()) {
                oldestHuman = humans.get(i);
            }
        }
        return oldestHuman;
    }
    public static Human geYoungestHuman (ArrayList<Human> humans) {
        Human youngestHuman = humans.get(0);
        for (int i = 1; i < humans.size(); i++) {
            if (humans.get(i).getAge() < youngestHuman.getAge()) {
                youngestHuman = humans.get(i);
            }
        }
        return youngestHuman;
    }

    public static void addHuman(ArrayList<Human> humans) {
        String[] FIO = new String[3];
        Scanner enter = new Scanner(System.in);
        System.out.print("Введите ФИО или 1 для выхода: ");
        String inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
            startProgram(humans);
        } else {
            FIO = inputMessage.split(" ");
        }
        Sex sex = Sex.Male;
        System.out.println("Выберите пол или\n1. Мужской\n2. Женский\nЛюбой другой текст: выход");
        System.out.print("Введите цифру: ");
        inputMessage = enter.nextLine();
        if (inputMessage.equals("1")) {
            sex = Sex.Male;
        } else if (inputMessage.equals("2")) {
            sex = Sex.Female;
        } else {
            System.out.println("Выход...");
            System.exit(0);
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
        humans.add(human);
    }
    public static void printAllHumans(ArrayList<Human> humans) {
        for (int i = 0; i < humans.size(); i++) {
            System.out.println(i + ". " + humans.get(i));
        }
    }
    public static void addBloodline(ArrayList<Human> humans) {
        if (humans.size() < 1) {
            System.out.println("Династия пуста");
        } else {
            System.out.println("Выберете человека из списка:");
            printAllHumans(humans);
            Scanner enter = new Scanner(System.in);
            int inputMessage = enter.nextInt();
            Human human = humans.get(inputMessage);
            System.out.println("1. Добавить родителя\n2. Добавить дитя");
            inputMessage = enter.nextInt();
            int valueBlood = inputMessage;
            System.out.println("Выберете человека из списка:");
            printAllHumans(humans);
            inputMessage = enter.nextInt();
            Human bloodlineHuman = humans.get(inputMessage);
            if(valueBlood == 1) {
                Human.setParent(bloodlineHuman, human);
            } else {
                Human.setChild(human, bloodlineHuman);
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