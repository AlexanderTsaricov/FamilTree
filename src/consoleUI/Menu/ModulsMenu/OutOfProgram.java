package consoleUI.Menu.ModulsMenu;

import Presenter.Presenter;
import Service.ServiceHumanFamily;

import java.io.IOException;

public class OutOfProgram implements MenuFunc{
    private boolean flag = true;
    @Override
    public String getMenuItemName() {
        return "Выход из программы";
    }
    public boolean getFlag() {
        return flag;
    }
    @Override
    public void use(Presenter presenter) throws IOException {
        presenter.saveFamily();
        flag = false;
        System.out.println("Выход из программы");
    }
}
