package com.fhnw.swa.contact;

import java.util.Collection;
import java.util.Optional;

/**
 * The repository interface for all contact repository implementations.
 *
 * @author Siv Elin Ødegård
 */
interface ContactRepository {

    /**
     * Get list of all contacts
     * @return all contacts
     */
    Collection<Contact> listAll();

    /**
     * Find contact by Firstname.
     * @param name Firstname of the contact to look for.
     * @return contact with the given firstname, if exists.
     */
    Optional<Contact> findByFirstname(String name);

    /**
     * Get contact by ID
     * @param id the identification of the Contact to retrieve.
     * @return contact with the correct id.
     */
    Contact getById(long id);

    /**
     * Save the contact to the database.
     * @param contact new contact.
     */
    void save(Contact contact);

    /**
     * Update the database with the contact's new information.
     * @param contact with new information.
     */
    void update(Contact contact);
}

