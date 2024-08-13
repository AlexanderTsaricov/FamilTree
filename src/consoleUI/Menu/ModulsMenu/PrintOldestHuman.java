package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

public class PrintOldestHuman implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать старшего члена династии";
    }

    @Override
    public void use(Menu menu) {
        menu.printOldestPeople();
    }
}
