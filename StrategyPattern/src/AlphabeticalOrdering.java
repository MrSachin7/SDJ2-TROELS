import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphabeticalOrdering implements OrderStrategy{
    @Override
    public void orderList(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
}
