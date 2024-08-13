package Presenter;

import Service.ModulsService.family.FamilyTree;
import Service.ModulsService.human.Human;
import Service.ModulsService.human.Sex;
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
    public void setBloodLine (String typeConnection, int indexHuman, int indexUseHuman) {
        FamilyTree<Human> family = service.getFamilyTree();
        Human human = family.getObjList().get(indexHuman);
        Human useHuman = family.getObjList().get(indexUseHuman);
        switch (typeConnection) {
            case "1":
                service.setParent(human, useHuman);
                break;
            case "2":
                service.setChild(human, useHuman);
                break;
            case "3":
                service.setSpouse(human, useHuman);
                break;
        }
    }
    public void addHuman (String[] FIO, Sex sex, boolean alive, Calendar dateOfBirth, int withParentsOrNo, int parentIndex) {
        Human human = new Human(FIO[0], FIO[1], FIO[2], sex, alive, dateOfBirth);
        service.addHuman(human);
        Human parent = service.getHumansList().get(parentIndex);
        if (withParentsOrNo == 1) {
            service.setParent(human, parent);
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
        Human oldHuman = service.getOldestHuman();
        int indent = 1;
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (oldHuman.getSpouse() != null) {
            sb.append(oldHuman + " супруг/га: " + oldHuman.getSpouse() + "\n");
        } else {
            sb.append(oldHuman + "\n");
        }
        sb.append(sIndent + "Дети:" + "\n");
        indent+=1;
        for (int i = 0; i < oldHuman.getChildrens().size(); i++) {
            sb = getStringBilderDynasty(service, indent, sb, oldHuman.getChildrens().get(i));
        }
        return sb.toString();
    }
    public StringBuilder getStringBilderDynasty(ServiceHumanFamily servise, int indent, StringBuilder sb, Human human) {
        String sIndent = " ";
        for (int i = 1; i < indent; i++) {
            sIndent = sIndent + " ";
        }
        if (human.getSpouse() != null) {
            sb.append(sIndent + human + " супруг/га: " + human.getSpouse() + "\n");
        } else {
            sb.append(sIndent + human + "\n");
        }
        if (human.getChildrens().size() > 0) {
            System.out.println(sIndent + sIndent + "Дети:" + "\n");
            indent += 1;
            ServiceHumanFamily newservice = servise;
            for (int i = 0; i < human.getChildrens().size(); i++) {
                sb = getStringBilderDynasty(newservice, indent, sb, human.getChildrens().get(i));
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

