package consoleUI.Menu.ModulsMenu;

import Service.ServiceHumanFamily;

public class PrintDinasty implements MenuFunc {
    @Override
    public String getMenuItemName() {
        return "Показать династию";
    }

    @Override
    public void use(ServiceHumanFamily service) {
        service.human = service.getOldestHuman();
        int indent = 1;
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (service.human.getSpouse() != null) {
            System.out.println(sIndent + service.human + " супруг/га: " + service.human.getSpouse());
        } else {
            System.out.println(service.human);
        }
        System.out.println(sIndent + "Дети:");
        indent+=1;
        for (int i = 0; i < service.human.getChildrens().size(); i++) {
            service.human = service.human.getChildrens().get(i);
            use(service, indent);
        }
    }

    public void use(ServiceHumanFamily servise, int indent) {
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (servise.human.getSpouse() != null) {
            System.out.println(sIndent + servise.human + " супруг/га: " + servise.human.getSpouse());
        } else {
            System.out.println(sIndent + servise.human);
        }
        if (servise.human.getChildrens().size() > 0) {
            System.out.println(sIndent + sIndent + "Дети:");
            indent += 1;
            ServiceHumanFamily newservice = servise;
            for (int i = 0; i < newservice.human.getChildrens().size(); i++) {
                newservice.human = newservice.human.getChildrens().get(i);
                use(newservice, indent);
            }
        }
    }
}
