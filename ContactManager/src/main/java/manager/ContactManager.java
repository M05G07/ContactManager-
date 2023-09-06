package manager;

import manager.ContactCategory;

public class ContactManager <T> {

    //added Instance vars
    private final T name;

    private final T surname;

    private final T phoneNumber;

    private final ContactCategory relation;

    //added constructor
    public ContactManager(T name, T surname, T phoneNumber, ContactCategory relation) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
    }

    public T getName() {
        return name;
    }

    public T getSurname() {
        return surname;
    }

    public T getPhoneNumber() {
        return phoneNumber;
    }

    public ContactCategory getRelation() {
        return relation;
    }

    //Custom toString() Implementation

    @Override
    public String toString() {
        return "Contact Details: " + name + " " + surname + " " + phoneNumber + " " + relation;


    }
}
