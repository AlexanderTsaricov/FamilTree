package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

public class PrintFamilyList implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать династию списком";
    }

    @Override
    public void use(Menu menu) {
        menu.printDinastyToList();
    }
}
