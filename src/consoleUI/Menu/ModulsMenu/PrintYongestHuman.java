package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

public class PrintYongestHuman implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать младшего члена династии";
    }

    @Override
    public void use(ServiceHumanFamily service) {
        if (service.getHumansList().size() < 1) {
            System.out.println("Династия пуста");
        } else {
            System.out.println(service.getYoungestHuman());
        }
    }
}
