package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;
import Service.ServiceHumanFamily;

public class PrintDinasty implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать династию";
    }

    @Override
    public void use(Presenter presenter) {
        System.out.println(presenter.getDytansy());
    }
}
