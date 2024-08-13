package consoleUI.Menu.ModulsMenu;
import consoleUI.Menu.Menu;

public class OutOfProgram implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Выход из программы";
    }
    @Override
    public void use(Menu menu) {
        menu.out();
    }
}
