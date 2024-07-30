package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

public class PrintOldestHuman implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать старшего члена династии";
    }

    @Override
    public void use(ServiceHumanFamily servise) {
        if (servise.getHumansList().size() < 1) {
            System.out.println(servise.ERROR);
        } else {
            System.out.println(servise.getOldestHuman());
        }
    }
}
