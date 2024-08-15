package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;
import Service.ServiceHumanFamily;
import consoleUI.Menu.Menu;

import java.io.IOException;

public interface MenuFunc {
    String getMenuItemName();
    void use(Menu menu) throws IOException;
}
