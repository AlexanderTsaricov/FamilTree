package Presenter;

import Service.ServiceHumanFamily;

import java.io.IOException;
import java.util.Calendar;

public class Presenter {
    private ServiceHumanFamily service;
    private String inputMessage;

    public String stateDynasty(){
        if(service.getHumansList().size() > 0) {
            return "Династия заполнена";
        } else {
            return "Династия пуста";
        }
    }
    public boolean boolStateDynasty () {
        if(service.getHumansList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public Presenter () throws IOException, ClassNotFoundException {
        service = new ServiceHumanFamily();
    }
    public void setInput (String input) {
        this.inputMessage = input;
    }
    public String getHumanList() {
        String outputMessage = "";
        for (int i = 0; i < service.getHumansList().size(); i++) {
            outputMessage += i + 1 + ". " + service.getHumansList().get(i).toString() + "\n";
        }
        return outputMessage;
    }
    public void setBloodLine (String typeConnection, int human, int connectHuman) {
        service.setTempHuman(service.getHumansList().get(human));
        service.setHumanFromFamily(service.getHumansList().get(connectHuman));
        switch (typeConnection) {
            case "1":
                service.setParent();
                break;
            case "2":
                service.setChild();
                break;
            case "3":
                service.setSpouse();
                break;
        }
    }
    public void addHuman (String[] FIO, boolean alive, Calendar dateOfBirth, int withParentsOrNo) {
        service.newHuman(FIO[0], FIO[1], FIO[2], alive, dateOfBirth);
        service.addHuman();
        if (withParentsOrNo == 1) {
            service.setParent();
        }
    }
    public void saveFamily() throws IOException {
        service.save();
    }
    public String getOldestHuman() {
        return service.getOldestHuman().toString();
    }
    public String getYoungestHuman() {
        return service.getYoungestHuman().toString();
    }
    public String getDytansy(){
        StringBuilder sb = new StringBuilder();
        service.setTempHuman(service.getOldestHuman());
        int indent = 1;
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (service.getTempHuman().getSpouse() != null) {
            sb.append(service.getTempHuman() + " супруг/га: " + service.getTempHuman().getSpouse());
        } else {
            sb.append(service.getTempHuman());
        }
        sb.append(sIndent + "Дети:");
        indent+=1;
        for (int i = 0; i < service.getTempHuman().getChildrens().size(); i++) {
            service.setTempHuman(service.getTempHuman().getChildrens().get(i));
            sb = getStringBilderDynasty(service, indent, sb);
        }
        return sb.toString();
    }
    public StringBuilder getStringBilderDynasty(ServiceHumanFamily servise, int indent, StringBuilder sb) {
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (servise.getTempHuman().getSpouse() != null) {
            sb.append(sIndent + servise.getTempHuman() + " супруг/га: " + servise.getTempHuman().getSpouse());
        } else {
            sb.append(sIndent + servise.getTempHuman());
        }
        if (servise.getTempHuman().getChildrens().size() > 0) {
            System.out.println(sIndent + sIndent + "Дети:");
            indent += 1;
            ServiceHumanFamily newservice = servise;
            for (int i = 0; i < newservice.getTempHuman().getChildrens().size(); i++) {
                newservice.setTempHuman(newservice.getTempHuman().getChildrens().get(i));
                sb = getStringBilderDynasty(newservice, indent, sb);
            }
        }
        return sb;
    }
    public void sort(String typeSort) {
        switch (typeSort) {
            case "1":
                service.sortByName();
                break;
            case "2":
                service.sortByAge();
                break;
        }
    }
    public String getErrorMessage() {
        return service.getError();
    }
}

