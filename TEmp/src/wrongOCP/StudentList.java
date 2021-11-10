package wrongOCP;

import java.util.List;

public class StudentList {
    private List<EUStudent> euStuents;
    private List<NonEuStudent> nonEuStudents;

    public void addEuStudent(EUStudent euStuent){
        euStuents.add(euStuent);
    }
    public void addNonEuStudents(NonEuStudent nonEuStudent){
        nonEuStudents.add(nonEuStudent);
    }
    public double getTotalFees(){
        double count =0;
        for (EUStudent i:euStuents
             ) {
            count+= i.getFees();

        }
        for (NonEuStudent j:nonEuStudents
             ) {
            count+= j.getFees();

        }
        return count;
    }

}
