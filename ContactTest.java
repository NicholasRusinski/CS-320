package testweek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

	@Test
    public void testContactClass() {
        Contact contact = new Contact("1234567890", "Adam", "Sandler", "3060683325", "123 this is an address");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Adam", contact.getFirstName());
        assertEquals("Sandler", contact.getLastName());
        assertEquals("3060683325", contact.getPhone());
        assertEquals("123 this is an address", contact.getAddress());
    }

    
     @Test
        public void testContactIdLengthGreaterThan10() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("12345678901", "Adam", "Sandler", "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testFirstNameLengthGreaterThan10() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Long Name J", "Sandler", "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testLastNameLengthGreaterThan10() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", "Long Name J", "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testPhoneLengthGreaterThan10() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", "Sandler", "12345678901", "123 this is an address");
            });
        }

        @Test
        public void testPhoneLengthLessThan10() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", "Sandler", "123456789", "123 this is an address");
            });
        }

        @Test
        public void testAddressLengthGreaterThan30() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", "Sandler", "3060683325", "1234567890123456789012345678901");
            });
        }

            
        @Test
        public void testContactIdNull1() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact(null, "Adam", "Sandler", "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testFirstNameNull() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", null, "Sandler", "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testLastNameNull() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", null, "3060683325", "123 this is an address");
            });
        }

        @Test
        public void testPhoneNull() {
            assertThrows(IllegalArgumentException.class, () -> {
                new Contact("1234567890", "Adam", "Sandler", null, "123 this is an address");
            });
        } 
}
