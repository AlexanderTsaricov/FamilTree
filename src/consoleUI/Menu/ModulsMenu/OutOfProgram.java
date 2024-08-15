package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

import java.io.IOException;

public class OutOfProgram implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Выход из программы";
    }
    @Override
    public void use(Menu menu) throws IOException {
        menu.out();
    }
}
