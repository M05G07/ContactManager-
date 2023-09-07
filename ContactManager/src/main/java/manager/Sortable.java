package manager;

import java.util.List;
@FunctionalInterface
public interface Sortable <T> {
    void sortContentofList( List<T> list);
}
