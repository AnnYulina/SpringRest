package product.star.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.star.facade.ContactFacade;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private  final ContactFacade contactFacade;

    @Autowired
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }
    @PostMapping
    public ContactDto createContact(@RequestBody ContactDto contactDto){
        return contactFacade.createContact(contactDto);
    }

    @GetMapping("/{contactId}")
    public ContactDto getContact(@PathVariable Long contactId){
        return  contactFacade.getContact(contactId);
    }

    @GetMapping()
    public ContactsDto getContacts(){
        return  contactFacade.getContacts();
    }

    @PutMapping("/{contactId}")
    public ContactDto putContact(@PathVariable Long contactId, @RequestBody ContactDto contactDto){
        return  contactFacade.changeContact(contactId,contactDto);
    }
}
