package consoleUI.Menu.ModulsMenu;

import consoleUI.Menu.Menu;

public class AddFamilyConnection implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Добавить фамильную связь";
    }

    @Override
    public void use(Menu menu) {
        menu.addConnectionPeople();
    }
}
