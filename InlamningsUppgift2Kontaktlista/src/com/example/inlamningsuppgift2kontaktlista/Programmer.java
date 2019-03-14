package com.example.inlamningsuppgift2kontaktlista;

/**
 * Sub-klassen Programmer
 * För ett enkelt program som visar meny för
 * kontaktlista.
 *
 * @author  Sofia Ridderstad
 * @version 1.0
 * @since   2018-10-25
 */

public class Programmer extends Person{
    private String sprak1;
    private String sprak2;
    private String position;


    public Programmer(String name, String number, String mail, String sprak1, String sprak2, String position) {
        super(name, number, mail);
        this.sprak1 = sprak1;
        this.sprak2 = sprak2;
        this.position = position;
    }



    public String getSprak1() { return sprak1; }

    public String getSprak2() { return sprak2; }

    public String competence() { return getSprak1() + " och " + getSprak2(); }

    public String getPosition() { return position; }

    public static Programmer createProgrammer(String name, String number, String mail, String sprak1, String sprak2, String position) {
        return new Programmer(name, number, mail, sprak1,sprak2, position);
    }
}
