package RightOCP;

import java.util.List;

public class StudentList {
    private List<Student> studentList;

    public double getTotalFees(){
        double count=0;
        for (Student i:studentList
             ) {
            count+=i.getFees();

        }
        return count;
    }
}
