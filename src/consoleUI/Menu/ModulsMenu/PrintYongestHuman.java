package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

public class PrintYongestHuman implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать младшего члена династии";
    }

    @Override
    public void use(Menu menu) {
        menu.printYoungestPeople();
    }
}
