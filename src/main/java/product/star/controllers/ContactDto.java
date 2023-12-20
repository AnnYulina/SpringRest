package product.star.controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import product.star.Contact;

public class ContactDto {
    @JsonProperty("contactId")
    private long contactId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("email")
    private String email;

  public ContactDto() {
    }

    public ContactDto(long contactId, String name, String lastName, String phoneNumber, String email) {
        this.contactId = contactId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ContactDto(Contact contact) {
        this.contactId = contact.getContactId();
        this.name = contact.getName();
        this.lastName = contact.getLastName();
        this.phoneNumber = contact.getPhoneNumber();
        this.email = contact.getEmail();
    }

    public long getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
