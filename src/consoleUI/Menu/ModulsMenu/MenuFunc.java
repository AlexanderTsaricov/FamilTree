package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

import java.io.IOException;

public interface MenuFunc {
    String getMenuItemName();
    void use(ServiceHumanFamily service) throws IOException;
}
