package manager;

import java.util.*;

import java.util.stream.Collectors;

public class ContactRunner {
    public static void main(String[] args) {
        /** Creation of ArrayList to Store Contacts
         **/

        List<ContactManager> contactBook = new ArrayList<>();

        /** Implementation of IF Addable [Add Element + Remove Duplicates] **/
        Addable<ContactManager> checker = (String name, String surname, String phoneNumber,
                                           ContactCategory relation) -> {
            ContactManager person = new ContactManager(name, surname, phoneNumber, relation);

            contactBook.add(person);

            Set<ContactManager> unique = contactBook.stream().collect(Collectors.toSet());

            contactBook.clear();

            contactBook.addAll(unique);

        } ;

        /** Implementation of IF Printable [Print Content of contactBook] **/
        Printable<ContactManager> printer = (List<ContactManager> list) -> {
            list.forEach((ContactManager person) -> System.out.println(person));
        };

        /** Implementation of IF Sortable **/
        Sortable<ContactManager> sorter = (List<ContactManager> list) -> {
            Comparator<ContactManager> handler = Comparator.comparing(ContactManager::getSurname).
                    thenComparing(ContactManager::getName);
            Collections.sort(list,handler);
        };



    }
}









