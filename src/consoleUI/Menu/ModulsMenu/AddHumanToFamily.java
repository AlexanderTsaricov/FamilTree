package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

public class AddHumanToFamily implements MenuFunc {

    @Override
    public String getMenuItemName() {
        return "Добавить нового члена династии";
    }

    @Override
    public void use(Menu menu) {
        menu.addPeople();
    }
}
