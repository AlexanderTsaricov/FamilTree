package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;

public class PrintOldestHuman implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать старшего члена династии";
    }

    @Override
    public void use(Presenter presenter) {
        if (presenter.boolStateDynasty()) {
            System.out.println(presenter.stateDynasty());
        } else {
            System.out.println(presenter.getOldestHuman());
        }
    }
}
