package RightSRP;

import WrongSRP.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
    }
}
