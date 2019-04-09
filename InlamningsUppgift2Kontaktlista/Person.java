package com.example.inlamningsuppgift2kontaktlista;

/**
 * Super-klassen Person
 * För ett enkelt program som visar meny för
 * kontaklista.
 *
 * @author  Sofia Ridderstad
 * @version 1.0
 * @since   2018-10-25
 */

public class Person {
    private String name;
    private String number;
    private String mail;

    public Person(String name, String number, String mail){
        this.name = name;
        this.number = number;
        this.mail = mail;
    }

    public String getName() { return name; }

    public String getNumber() { return number; }

    public String getMail() { return mail; }
}
