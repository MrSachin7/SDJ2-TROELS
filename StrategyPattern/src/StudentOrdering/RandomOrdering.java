package StudentOrdering;

import java.util.Collections;
import java.util.List;

public class RandomOrdering implements OrderStrategy{

    @Override
    public void orderList(List<Student> students) {
        Collections.shuffle(students);
    }
}
