package com.fhnw.swa.contact;

import java.util.Collection;
import java.util.Optional;

/**
 * The service interface for all contact service implementations.
 *
 * @author Siv Elin Ødegård
 */
public interface ContactService {

    /**
     *  Get list of all contacts
     * @return  all contacts
     */
    Collection<Contact> listAllContacts();

    /**
     * Find contact by Firstname.
     * @param name Firstname of the contact to look for.
     * @return contact with the given firstname, if exists.
     */
    Optional<Contact> findContactByName(String name);

    /**
     * Get contact by ID
     * @param id the identification of the Contact to retrieve.
     * @return contact with the correct id.
     */
    Contact getContactById(Long id);

    /**
     * Save the contact to the repository.
     * @param contact new contact.
     */
    void save(Contact contact);

    /**
     * Update the repository with the contact's new information.
     * @param contact with new information.
     */
    void update(Contact contact);
}
