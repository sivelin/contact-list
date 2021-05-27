package com.fhnw.swa.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.springframework.ui.Model;

import com.fhnw.swa.contact.Contact;
import com.fhnw.swa.contact.ContactService;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;


/**
 * Spring controller class for Contacts
 *
 * @author Siv Elin Ødegård
 */
@AllArgsConstructor
@Controller
@RequestMapping("/contacts")
class ContactController {

    private ContactService contactService;

    /**
     * Show all Contacts with the given contact name
     * @param contactName name of contacts to list.
     * @param model to send contact to html site.
     * @return html site contacts.
     */
    @GetMapping()
    public String list(String contactName, Map<String, Object> model) {
        Collection<Contact> contacts = StringUtils.isEmpty(contactName)
                ? contactService.listAllContacts()
                : contactService.findContactByName(contactName)
                        .map(Collections::singleton)
                        .orElseGet(Collections::emptySet);
        model.put("contacts", contacts);
        return "contacts";
    }

    /**
     * Show single Contact
     * @param id of the contact to show.
     * @param model to send contact to html site.
     * @return html site show or if something went wrong error will be returend.
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable long id, Model model) {
        Optional<Contact> contact = Optional.ofNullable(contactService.getContactById(id));
        if(contact.isPresent()){
            model.addAttribute("contact", contact.get());
            return "show";
        }
        return "404";
    }

    /**
     * Initialize new contact and navigate to create site.
     * @param model to send contact to html site.
     * @return html site create.
     */
    @RequestMapping(method = RequestMethod.GET, params = { "form" })
    public String getForm(Model model) {
        model.addAttribute("contact", new Contact(
                (long) (contactService.listAllContacts().size()+1),
                "","","","","","","",1234));
        return "create";
    }

    /**
     * Save newly created contact and redirect to contacts site.
     * @param contact Contact with information from User.
     * @param result binding result.
     * @return redirection to contacts site.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String create(Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "create";
        } else {
            contactService.save(contact);
            return "redirect:contacts";
        }
    }

    /**
     * Navigate to single Contact's update site.
     * @param id of the contact to update.
     * @param model to send contact to html site.
     * @return html site update or if something went wrong error will be returned.
     */
    @RequestMapping(value="/{id}", method = RequestMethod.GET, params = { "update-form" })
    public String getUpdateForm(@PathVariable long id, Model model) {
        Optional<Contact> contact = Optional.ofNullable(contactService.getContactById(id));
        if(contact.isPresent()){
            model.addAttribute("contact", contact.get());
            return "update";
        }
        return "404";
    }

    /**
     * Save newly updated contact and redirect to contacts site.
     * @param contact Contact with new information from User.
     * @param result binding result.
     * @return redirection to contacts site it there was no error and the contact to update exists.
     */
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable long id, Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "update";
        }
        Optional<Contact> c = Optional.ofNullable(contactService.getContactById(id));
        if(c.isPresent()){
            contactService.update(contact);
            return "redirect:/contacts";
        }
        return "404";
    }
}
