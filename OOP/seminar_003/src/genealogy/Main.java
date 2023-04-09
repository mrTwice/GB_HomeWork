package genealogy;

import genealogy.control.InputData;
import genealogy.humans.Female;
import genealogy.humans.Male;
import genealogy.humans.Person;
import genealogy.tree.FamilyTree;
import genealogy.tree.Generations;
import genealogy.tree.Nodes;

import java.util.Scanner;

import static genealogy.control.InputData.createFemalePerson;
import static genealogy.control.InputData.createMalePerson;
import static genealogy.control.View.printMenu;
import static genealogy.control.View.printSubMenuGender;


public class Main {
    public static void main(String[] args) {
        FamilyTree testFamily = new FamilyTree();

        Person female1 = new Female( "Петрова", "Анна", "Николаевна", "10-10-2001");
        Person male1 = new Male("Иванов", "Виталий", "Иванович", "11-11-2000");
        Person male2 = new Male( "Сидоров", "Олег", "Васильевич", "05-01-1999");

        Generations testGeneration = new Generations();
        testGeneration.addPersonToGeneration(female1);
        testGeneration.addPersonToGeneration(male1);
        testGeneration.addPersonToGeneration(male2);
        testGeneration.printAllPersonsInGeneration();

        Nodes testNode = new Nodes(male1.getIdPerson(), female1.getIdPerson());
        testGeneration.addNodesToGenerations(testNode);

        testFamily.addGenerationToTree(testGeneration);
        testFamily.printPersonForAllGenerations();



        while (true){
            FamilyTree myFamily = new FamilyTree();
            printMenu();
            Scanner consoleInput = new Scanner(System.in);
            String menuChoise = consoleInput.nextLine();
            switch (Integer.parseInt(menuChoise)){
                case 1:
                    printSubMenuGender();
                    int genderPerson = Integer.parseInt(consoleInput.nextLine());
                    if (genderPerson == 1){
                        Person person = createMalePerson();
                        myFamily.addPerson(person);
                    }
                    if (genderPerson == 2){
                        Person person = createFemalePerson();
                        myFamily.addPerson(person);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    myFamily.printPersonForAllGenerations();
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }


    }

}
