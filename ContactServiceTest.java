package testweek;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    
    private ContactService contactService;
    private Contact contact;
    
    @BeforeEach
    void setUp() {
        contactService = new ContactService(10);
        contact = new Contact("1234567890", "Adam", "Sandler", "3060683325", "123 this is an address");
    }

    @Test
    void testAddContact() {
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContactById("1234567890");

        assertNotNull(retrievedContact);
        assertEquals("1234567890", retrievedContact.getContactId()); 
        assertEquals("Adam", retrievedContact.getFirstName());
        assertEquals("Sandler", retrievedContact.getLastName());
        assertEquals("3060683325", retrievedContact.getPhone());
        assertEquals("123 this is an address", retrievedContact.getAddress());
    }
    
    @Test
    void testAddDupContact() {
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        Contact deletedContact = contactService.getContactById("1234567890");
        assertNull(deletedContact);
    }
    
    @Test
    void testDeleteNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("NonExistingId"),
                "Not found.");
    }

    @Test
    void testUpdateContact() {
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Johny", "Dep", "4060683325", "321 this is an address");
        Contact updatedContact = contactService.getContactById("1234567890");
        assertNotNull(updatedContact);
        assertEquals("Johny", updatedContact.getFirstName());
        assertEquals("Dep", updatedContact.getLastName());
        assertEquals("4060683325", updatedContact.getPhone());
        assertEquals("321 this is an address", updatedContact.getAddress());
    }
    
    @Test
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContact("NonExistingId", "Updated", "Name", "9876543210", "Updated Address"),
                "Not found.");
    }

}
