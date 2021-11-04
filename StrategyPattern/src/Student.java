public class Student {
    private String studentNumber;
    private String name;

    public Student(String studentNumber, String name){
        this.studentNumber=studentNumber;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                '}'+"\n";
    }
}
