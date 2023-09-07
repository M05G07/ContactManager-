package manager;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ContactRunnerTest {

    /** Creation of ArrayList for Testing **/
    List<ContactManager> contactBook  = new ArrayList<>();


    @BeforeAll
    @DisplayName("START")
    @EnabledOnOs(value = OS.WINDOWS)
    public static void starter() {
        System.out.println(" -> Start of Testing <-");
    }


   
    @DisplayName("Creation of Instance")
    @EnabledOnOs(value = OS.WINDOWS)
    @Test
    public void shouldCreateContact() {
        Addable<ContactManager> checker = (String name, String surname, String phoneNumber,
                                           ContactCategory relation) -> {
            ContactManager person = new ContactManager(name, surname, phoneNumber, relation);

            contactBook.add(person);

            Set<ContactManager> unique = contactBook.stream().collect(Collectors.toSet());

            contactBook.clear();

            contactBook.addAll(unique);
        };

        checker.checkPerson("Pepa","Twig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Pepa","Twig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Lada","Swag","124",ContactCategory.POTENTIAL_CUSTOMER);
        checker.checkPerson("Anna","Pigeon", "+421",ContactCategory.VENDOR);
        checker.checkPerson("Anna","Pigeon", "+421",ContactCategory.VENDOR);
        checker.checkPerson("Jimmy", "Fresh", "+065", ContactCategory.CUSTOMER);
    }

    @DisplayName("Printing of Content")
    @EnabledOnOs(value = OS.WINDOWS)
    @Test
    public void shouldPrintContent() {
        shouldCreateContact();
        Printable<ContactManager> printer = (List<ContactManager> list) -> {
            list.forEach((ContactManager person) -> System.out.println(person));
        };
        printer.retrieveContentofList(contactBook);
    }

    @DisplayName("Sorting of Content")
    @EnabledOnOs(value = OS.WINDOWS)
    @Test
    public void shouldSortList() {
        Sortable<ContactManager> sorter = (List<ContactManager> list) -> {
            Comparator<ContactManager> handler = Comparator.comparing(ContactManager::getSurname).
                    thenComparing(ContactManager::getName);
            Collections.sort(list,handler);
        };

        shouldCreateContact();
        sorter.sortContentofList(contactBook);
        shouldPrintContent();
    }


    @AfterAll
    @EnabledOnOs(value = OS.WINDOWS)
    @DisplayName("END")
    public static void finishing() {
        System.out.println(" -> End of Testing <- ");
    }
}