public class ContactManager <T> {

    private final T name;

    private final T surname;

    private final T phoneNumber;

    private final ContactCategory relation;

    public ContactManager(T name, T surname, T phoneNumber, ContactCategory relation) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
    }
}
