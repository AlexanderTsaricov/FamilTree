package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

import java.io.IOException;

public class OutOfProgram implements MenuFunc{
    public boolean flag = true;
    @Override
    public String getMenuItemName() {
        return "Выход из программы";
    }

    @Override
    public void use(ServiceHumanFamily service) throws IOException {
        service.save();
        flag = false;
        System.out.println("Выход из программы");
    }
}
