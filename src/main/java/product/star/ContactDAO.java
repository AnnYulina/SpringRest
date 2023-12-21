package product.star;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

public interface ContactDAO {
    Contact addContact(String name, String lastName, String phoneNumber, String email);
    Optional<Contact> findContact(Long contactId);
    List<Contact> getContacts();
}
