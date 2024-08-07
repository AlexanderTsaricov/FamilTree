package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;

import java.util.Scanner;

public class PrintFamilyList implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать династию списком";
    }

    @Override
    public void use(Presenter presenter) {
        System.out.println("Сортировка по:\n1. Имени\n2. Возрасту\nЛюбое другое значение: Без сортировки");
        Scanner enter = new Scanner(System.in);
        String typeSort = enter.nextLine();
        presenter.sort(typeSort);
        System.out.println(presenter.getHumanList());
    }
}
