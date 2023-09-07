package manager;

import java.util.Objects;

public class ContactManager {

    //added Instance vars
    private final String name;

    private final String surname;

    private final String phoneNumber;

    private final ContactCategory relation;

    //added constructor
    public ContactManager(String name, String surname, String phoneNumber, ContactCategory relation) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ContactCategory getRelation() {
        return relation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactManager that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && getRelation() == that.getRelation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPhoneNumber(), getRelation());
    }

    //Customized toString() Implementation

    @Override
    public String toString() {
        return "Contact Details: " + name + " " + surname + " " + phoneNumber + " " + relation;


    }
}


