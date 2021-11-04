package StudentOrdering;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentNumberOrdering implements OrderStrategy{
    @Override
    public void orderList(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentNumber().compareToIgnoreCase(o2.getStudentNumber());
            }
        });
    }
}
