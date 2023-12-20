package product.star.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.star.Contact;
import product.star.ContactDAO;
import product.star.controllers.ContactDto;
import product.star.controllers.ContactsDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactFacade {
    private final ContactDAO contactDAO;

    @Autowired
    public ContactFacade(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public ContactDto createContact(ContactDto contact){
        var newContact = contactDAO.addContact(contact.getName(), contact.getLastName(),
                contact.getPhoneNumber(), contact.getEmail());
        return new ContactDto(newContact);
    }

    public ContactDto getContact(long contactId){
        var foundContact = contactDAO.findContact(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found by Id: " + contactId));
        return new ContactDto(foundContact);
    }

    public ContactsDto getContacts(){
        var contacts = contactDAO.getContacts().stream().map(ContactDto::new).collect(Collectors.toList());
        return new ContactsDto(contacts);
    }

    public ContactDto changeContact(long contactId, ContactDto newContact){
        var foundContact = contactDAO.findContact(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found by Id: " + contactId));
        foundContact.setName(newContact.getName());
        foundContact.setLastName(newContact.getLastName());
        foundContact.setPhoneNumber(newContact.getPhoneNumber());
        foundContact.setEmail(newContact.getEmail());
        return new ContactDto(foundContact);
    }

}
