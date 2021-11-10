package WrongSRP;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }
    public void saveToDataBase(){
        //TODO some codes that saves this class to database..
    }
}
