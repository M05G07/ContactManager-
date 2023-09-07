package manager;

import java.util.Objects;

public class ContactManager {

    /** Properties of Instance of ContactManager **/
    private final String name;

    private final String surname;

    private final String phoneNumber;

    private final ContactCategory relation;

   /** Class Constructor **/
    public ContactManager(String name, String surname, String phoneNumber, ContactCategory relation) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
    }


    /** 4 x get Methods to return values of Instance Properties **/
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

    /** Customized equals() Implementation **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactManager that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && getRelation() == that.getRelation();
    }

    /** Customized hashCode() Implementation **/

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPhoneNumber(), getRelation());
    }

    /** Customized toString() Implementation **/

    @Override
    public String toString() {
        return "Contact Details: " + name + " " + surname + " " + phoneNumber + " " + relation;


    }
}


