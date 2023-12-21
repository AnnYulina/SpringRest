package product.star;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryContactDao implements ContactDAO {
    private Long contactId = 1L;
    private final Map<Long, Contact> contactsMap;

    public InMemoryContactDao() {
        this.contactsMap = new HashMap<>();
    }

    @Override
    public Contact addContact(String name, String lastName, String phoneNumber, String email) {
        Contact contact = new Contact(contactId, name, lastName, phoneNumber, email);
        contactsMap.put(contactId++, contact);
        return contact;
    }

    @Override
    public Optional<Contact> findContact(Long contactId) {
        return Optional.ofNullable(contactsMap.get(contactId));
    }

    @Override
    public List<Contact> getContacts() {
        return contactsMap.values().stream().toList();
    }

}
