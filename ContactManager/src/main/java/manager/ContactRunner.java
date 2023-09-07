package manager;

import java.util.*;

import java.util.stream.Collectors;

public class ContactRunner {
    public static void main(String[] args) {
        //Creation of ArrayList to Store Contacts
        List<ContactManager> contactBook = new ArrayList<>();

        //Added Implementation of IF Printable
        Printable<ContactManager> printer = (List<ContactManager> list) -> {
            list.forEach((ContactManager person) -> System.out.println(person));
        };

        //Added Implementation of IF Sortable
        Sortable<ContactManager> sorter = (List<ContactManager> list) -> {
            Comparator<ContactManager> handler = Comparator.comparing(ContactManager::getSurname).
                    thenComparing(ContactManager::getName);
            Collections.sort(list,handler);
        };


        //Adding Implementation of IF Addable [Add Element + Remove Duplicates]
        Addable<ContactManager> checker = (String name, String surname, String phoneNumber,
                                           ContactCategory relation) -> {
            ContactManager person = new ContactManager(name, surname, phoneNumber, relation);

            contactBook.add(person);

            Set<ContactManager> unique = contactBook.stream().collect(Collectors.toSet());

            contactBook.clear();

            contactBook.addAll(unique);

        } ;


        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Lada","Pig","124",ContactCategory.POTENTIAL_CUSTOMER);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.POTENTIAL_CUSTOMER);
        checker.checkPerson("Anna","Pig", "+421",ContactCategory.VENDOR);

        sorter.sortContentofList(contactBook);

        printer.retrieveContentofList(contactBook);




        }




}









