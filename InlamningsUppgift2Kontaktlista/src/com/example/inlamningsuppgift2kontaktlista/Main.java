package com.example.inlamningsuppgift2kontaktlista;

import java.util.Scanner;

/**
 * Ett enkelt program som visar en meny
 * för en kontaktlista där man kan lägga till,
 * visa, ändra, radera och göra en favoritlista.
 *
 * @author  Sofia Ridderstad
 * @version 1.0
 * @since   2018-10-25
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Function function = new Function();

    public static void main(String[] args) {

        boolean quit = false;
        startMeny();
        printActions();
        while (!quit) {
            System.out.println("\nVälj: (8 för att se Meny)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Programmet sängs ner...");
                    quit = true;
                    break;
                case 1:
                    function.printProgrammer();
                    break;
                case 2:
                    addNewProgrammer();
                    break;
                case 3:
                    updateProgrammer();
                    break;
                case 4:
                    function.printProgrammer();
                    addFavorite();
                    break;
                case 5:
                    function.printFavorite();
                    break;
                case 6:
                    removeProgrammer();
                    break;
                case 7:
                    queryProgrammer();
                    break;
                case 8:
                    printActions();
                    break;
            }

        }
    }

    /**
     * Metoden där användaren matar in värden
     * för ny kontakt till kontaktlistan
     * @return String returnerar tillagd kontakts värden
     */

    private static void addNewProgrammer() {
        System.out.println("Skriv ditt namn: ");
        String name = scanner.nextLine();
        System.out.println("Skriv ditt nummer: ");
        String number = scanner.nextLine();
        System.out.println("Skriv din mail: ");
        String mail = scanner.nextLine();
        System.out.println("Skriv ditt huvudprogrammeringsspråk: ");
        String sprak1 = scanner.nextLine();
        System.out.println("Skriv ditt andrahandsprogrammeringsspråk: ");
        String sprak2 = scanner.nextLine();
        Programmer newProgrammer = Programmer.createProgrammer(name, number, mail, sprak1, sprak2, "");
        if(function.addNewProgrammer(newProgrammer)) {
            System.out.println("Ny person tillagd: Namn: " + name + ", Nummer: " + number + ", Mail: " + mail +
                    ", Konmpetens inom: " + newProgrammer.competence());
        } else {
            System.out.println("Kan inte lägga till " + name + ", kontakten finns redan.");
        }
    }

    /**
     * Metoden låter användaren uppdatera en kontakt
     * i den befintliga kontaktlistan
     *
     * @return String returnerar vilken kontakt som uppdaterats och värden
     */

    private static void updateProgrammer() {
        System.out.println("Skriv namnet på den kontakt du vill uppdatera: ");
        String name = scanner.nextLine();
        Programmer existingProgrammerFunction = function.queryProgrammer(name);
        if(existingProgrammerFunction == null) {
            System.out.println("Kontakten kunde inte hittas.");
            return;
        }
        System.out.println("Skriv in nytt namn på kontakten: ");
        String newName = scanner.nextLine();
        System.out.println("Skriv in nytt nummer: ");
        String newNumber = scanner.nextLine();
        System.out.println("Skriv ny mail: ");
        String newMail = scanner.nextLine();
        System.out.println("Skriv ny huvudkompetens: ");
        String newSprak1 = scanner.nextLine();
        System.out.println("Skriv ny andrahandskompetens: ");
        String newSprak2 = scanner.nextLine();
        System.out.println("Skriv position: ");
        String newPosition = scanner.nextLine();
        Programmer newProgrammer = Programmer.createProgrammer(newName, newNumber, newMail, newSprak1, newSprak2, newPosition);
        if(function.updateProgrammer(existingProgrammerFunction, newProgrammer)) {
            System.out.println("Kontakten har uppdaterats!");
        } else {
            System.out.println("Kontakten gick inte att uppdatera!");
        }
    }

    /**
     * Metoden låter användaren lägga till favorit
     * från befintlig kontaktlista
     *
     * @return String returnerar att kontakten sparats som favorit
     */

    private static void addFavorite(){
        System.out.println("Skriv nummret på den kontakt du vill lägga till som favorit: ");
        int arraylistNumber = scanner.nextInt();

        function.addFavorite(arraylistNumber);
    }

    /**
     * Metoden låter användaren radera kontakt
     * från befintlig kontaktlista
     *
     * @return String returnerar vilken kontakt som raderats
     */

    private static void removeProgrammer() {
        System.out.println("Skriv in namnet på kontakten du vill radera: ");
        String name = scanner.nextLine();
        Programmer existingProgrammerFunction = function.queryProgrammer(name);
        if(existingProgrammerFunction == null) {
            System.out.println("Kontakten kunde inte hittas.");
            return;
        }
        if(function.removeProgrammer(existingProgrammerFunction)) {
            System.out.println("Kontakten har raderats.");
        } else {
            System.out.println("Kontakten kunde inte raderas.");
        }
    }

    /**
     * Metoden låter användaren söka kontakt
     * från befintlig kontaktlista
     *
     * @return String returnerar kontakt
     */

    private static void queryProgrammer() {
        System.out.println("Skriv namnet på kontakten du vill söka efter: ");
        String name = scanner.nextLine();
        Programmer existingProgrammerFunction = function.queryProgrammer(name);
        if(existingProgrammerFunction == null) {
            System.out.println("Kontakten kunde inte hittas.");
            return;
        }
        System.out.println("Namn: " + existingProgrammerFunction.getName() +
                ", Nummer: " + existingProgrammerFunction.getNumber() +
                ", Mail: " + existingProgrammerFunction.getMail() +
                ", Huvudkompetens: " + existingProgrammerFunction.getSprak1() +
                ", Andrahandskompetens: " + existingProgrammerFunction.getSprak2()+ ".");

    }

    /**
     * Metoden startar kontaktregistret
     *
     *
     * @return String returnerar programstart
     */

    private static void startMeny() { System.out.println("Startar kontaktregistret..."); }

    /**
     * Metoden visar meny för kontaktlistan
     * tillsammans med menyval
     *
     * @return String returnerar meny
     */

    private static void printActions() {
        System.out.println("\nVälj:\n");
        System.out.println("0 - Stäng av!\n" +
                "1 - Visa kontakter:\n" +
                "2 - Lägg till kontakt:\n" +
                "3 - Uppdatera kontakt:\n" +
                "4 - Lägg till favorit:\n" +
                "5 - Visa favoriter:\n" +
                "6 - Radera kontakt:\n" +
                "7 - Sök kontakt:\n"  +
                "8 - Visa lista med menyval:");
    }


}
