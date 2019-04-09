package com.example.inlamningsuppgift2kontaktlista;

import java.util.ArrayList;

/**
 * Metoder och functioner
 * För ett enkelt program som visar meny för
 * kontaktlista.
 *
 * @author  Sofia Ridderstad
 * @version 1.0
 * @since   2018-10-25
 */

public class Function {
    private ArrayList<Programmer> myProgrammer;
    private ArrayList<Programmer> myFavorite;

    public Function() {
        this.myProgrammer = new ArrayList<Programmer>();
        this.myFavorite = new ArrayList<Programmer>();
    }

    /**
     * Metoden skriver ut kontaktlistan
     * med namn och alla värden användaren tidigare matat in
     * för varje kontakt
     *
     */

    public void printProgrammer(){
        System.out.println("Personalregister:");
        for(int i=0; i<this.myProgrammer.size(); i++) {
            System.out.println((i+1) + ". Namn " +
                    this.myProgrammer.get(i).getName() + ", Nummer: " +
                    this.myProgrammer.get(i).getNumber() + ", Mail: " +
                    this.myProgrammer.get(i).getMail() + ", Huvudkompetens inom: " +
                    this.myProgrammer.get(i).getSprak1() + ", Andrahands kompetens: " +
                    this.myProgrammer.get(i).getSprak2() + " " +
                    this.myProgrammer.get(i).getPosition());
        }
    }

    /**
     * Metoden skriver ut favoritkontakter
     * för de favoriter användaren valt bland
     * befintliga kontakter i kontaktlistan
     *
     *
     */

    public void printFavorite(){
        System.out.println("Favoritkontakter:");
        for(int i=0; i<this.myFavorite.size(); i++) {
            System.out.println("Favorit nummer: " + (i+1) + ". Namn: " +
                    this.myFavorite.get(i).getName());
        }
    }

    /**
     * Metoden lägger till en favorit
     * i favoritlistan från befintlig kontaktlista.
     * Metoden hämtar befintlig kontakt från kontaktlistan
     * och sparar kontakten i en ny ArrayList.
     * Det går sen att både se lista med favoriter
     * och lägga till nya favoriter.
     * För att lägga till en favorit måste den finnas bland kontakter.
     * @param arrListnr parameter för arrListnr
     * @return boolean
     */

    public boolean addFavorite(int arrListnr){
        if(arrListnr<0) {
            System.out.println( "Nummret gick inte att hitta.");
            return false;
        }
        Programmer newFavorite = Programmer.createProgrammer(this.myProgrammer.get(arrListnr -1).getName(), "", "", "", "", "");
        myFavorite.add(newFavorite);
        System.out.println("Kontakten " + this.myProgrammer.get(arrListnr -1).getName() + ", har lagts till i Favoriter.");
        return true;
    }

    /**
     * Funktion hittar var i Arraylistan en kontakt finns
     *
     * @param programmer parameter för namn
     * @return int returnerar numret
     */

    private int findProgrammer(Programmer programmer) { return this.myProgrammer.indexOf(programmer); }

    /**
     * Metoden hittar var i Arraylistan en kontakt finns
     *
     * @param programmerName parameter för namn
     * @return int returnerar numret
     */

    private int findProgrammer(String programmerName) {
        for(int i=0; i<this.myProgrammer.size(); i++) {
            Programmer programmer = this.myProgrammer.get(i);
            if(programmer.getName().equals(programmerName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Metoden lägger till en kontakt i kontaktlistan
     * tillsammans med de värden man har matat in
     * @param programmer parameter för programmer
     * @return boolean
     */

    public boolean addNewProgrammer(Programmer programmer) {
        if(findProgrammer(programmer.getName()) >=0) {
            System.out.println("Kontakten är redan sparad.");
            return false;
        }
        myProgrammer.add(programmer);
        return true;
    }

    /**
     * Metoden uppdaterar en befintlig kontakt i kontaktlistan
     * tillsammans med de värden man har matat in.
     * I uppdatera kan man även lägga til position på kontakten.
     * Som skrivs ut om man visar kontaktlistan
     * efter att kontakten är uppdaterad.
     * @param oldProgrammer parameter för oldProgrammer
     * @param newProgrammer parameter för newProgrammer
     * @return boolean
     */

    public boolean updateProgrammer(Programmer oldProgrammer, Programmer newProgrammer){
        int foundPosition = findProgrammer(oldProgrammer);
        if(foundPosition<0) {
            System.out.println(oldProgrammer.getName() + ", gick inte att hitta.");
            return false;
        }
        this.myProgrammer.set(foundPosition, newProgrammer);
        System.out.println(oldProgrammer.getName() + ", har Uppdaterats med " + newProgrammer.getName());
        return true;
    }

    /**
     * Metoden letar upp kontakten man söker efter
     * från befintlig kontaktlista
     * @param name parameter för namn
     * @return String returnerar kontakten man sökt efter
     */

    public Programmer queryProgrammer(String name) {
        int position = findProgrammer(name);
        if(position >=0) {
            return this.myProgrammer.get(position);
        }
        return null;
    }

    /**
     * Metoden raderar kontakt
     * från befintlig kontaktlista
     * @param programmer parameter för programmer
     * @return boolean
     */

    public boolean removeProgrammer(Programmer programmer) {
        int foundPosition = findProgrammer(programmer);
        if(foundPosition <0) {
            System.out.println(programmer.getName() + " gick inte att hitta.");
            return false;
        }
        this.myProgrammer.remove(foundPosition);
        System.out.println(programmer.getName() + " har tagits bort!");
        return true;
    }
}
