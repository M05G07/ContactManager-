package manager;

import java.util.List;

@FunctionalInterface
public interface Printable<T> {
    void retrieveContentofList(List<T> list);

}
