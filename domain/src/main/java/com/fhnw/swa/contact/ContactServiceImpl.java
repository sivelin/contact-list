package com.fhnw.swa.contact;

import java.util.Collection;
import java.util.Optional;

/**
 * An implementation of the Contact Service
 *
 * @author Siv Elin Ødegård
 */
class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Collection<Contact> listAllContacts() {
        return contactRepository.listAll();
    }

    @Override
    public Optional<Contact> findContactByName(String name) {
        return contactRepository.findByFirstname(name);
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.getById(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactRepository.update(contact);
    }
}
