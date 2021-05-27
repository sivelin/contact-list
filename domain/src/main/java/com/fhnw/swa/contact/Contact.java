package com.fhnw.swa.contact;

import lombok.NonNull;
import lombok.Value;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;


/**
 * Represents a contact.
 *
 * @author Siv Elin Ødegård
 */
@Value
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private String firstname;
    private String lastname;
    private String nickname;
    private String number;
    private String email;

    private String street;
    private String town;
    private int plz;

    /**
     * Constructor to generate a new Contact.
     * @param id Contact's id. Must not be null.
     * @param firstname Contact's firstname
     * @param lastname Contact's lastname
     * @param nickname Contact's nickname
     * @param street Street where the contact currently lives at.
     * @param number Contact's phone number
     * @param email Contact's email adress
     * @param town Town where the contact currently lives at.
     * @param plz Postcode of the town where the contact currently lives at.
     */
    public Contact(@NonNull Long id, String firstname, String lastname, String nickname, String street, String number,String email,  String town, int plz) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.number = number;
        this.email = email;
        this.street = street;
        this.town = town;
        this.plz = plz;
    }

}
