package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;
import consoleUI.Menu.Menu;

public class PrintDinasty implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать династию";
    }

    @Override
    public void use(Menu menu) {
        menu.printDinasty();
    }
}
