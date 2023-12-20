package product.star.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import product.star.Contact;

import java.util.List;

public class ContactsDto {
    @JsonProperty("contacts")
    private List<ContactDto> contacts;

    public ContactsDto(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }
}
