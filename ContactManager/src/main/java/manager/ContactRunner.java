package manager;

import java.util.*;

import java.util.stream.Collectors;

public class ContactRunner {
    public static void main(String[] args) {
        //Creation of ArrayList to Store Contacts
        List<ContactManager> contactBook = new ArrayList<>();

        //Adding Implementation of IF Addable [Add Element + Remove Duplicates]
        Addable<ContactManager> checker = (String name, String surname, String phoneNumber,
                                           ContactCategory relation) -> {
            ContactManager person = new ContactManager(name, surname, phoneNumber, relation);

            contactBook.add(person);

            Set<ContactManager> cleaner = contactBook.stream().collect(Collectors.toSet());

            contactBook.clear();
            
            contactBook.addAll(cleaner);
        } ;

        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Lada","Pig","124",ContactCategory.POTENTIAL_CUSTOMER);
        checker.checkPerson("Pepa","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.COLD_CONTACT);
        checker.checkPerson("Rowana","Pig","123",ContactCategory.POTENTIAL_CUSTOMER);
        contactBook.forEach((ContactManager contact) -> System.out.println(contact));



        }



    }






