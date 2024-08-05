package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;
import Service.ServiceHumanFamily;

import java.io.IOException;

public interface MenuFunc {
    String getMenuItemName();
    void use(Presenter presenter) throws IOException;
}
