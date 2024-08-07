package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;

public class PrintYongestHuman implements MenuFunc{
    @Override
    public String getMenuItemName() {
        return "Показать младшего члена династии";
    }

    @Override
    public void use(Presenter presenter) {
        if (presenter.boolStateDynasty()) {
            System.out.println(presenter.stateDynasty());
        } else {
            System.out.println(presenter.getYoungestHuman());
        }
    }
}
