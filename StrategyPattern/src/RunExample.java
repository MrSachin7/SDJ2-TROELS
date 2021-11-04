import java.util.Arrays;
import java.util.List;

public class RunExample {
    public static void main(String[] args) {
        Student[] students = {
                new Student("254137", "Maria"),
                new Student("259974", "Peter"),
                new Student("324851", "Christian"),
                new Student("246513", "Ioana"),
                new Student("257631", "Petra"),
                new Student("238243", "Conrad"),
                new Student("264127", "Aaron"),
                new Student("312564", "Jacob"),
                new Student("234567", "Jonas"),
                new Student("243561", "Muhammad"),
                new Student("243698", "Troels")
        };
        List<Student> studentList= Arrays.asList(students);
        ExamScheduler shuffler = new ExamScheduler(new RandomOrdering());
        ExamScheduler alphabeticalOrder = new ExamScheduler(new AlphabeticalOrdering());
        ExamScheduler studentNumberOrder = new ExamScheduler(new StudentNumberOrdering());
        System.out.println("Random Order \n");
        shuffler.generateSchedule(studentList);
        System.out.println("........\n\n");
        System.out.println("Alphabetical Order \n");
        alphabeticalOrder.generateSchedule(studentList);
        System.out.println("........\n\n");
        System.out.println("Student Number Order \n");
        studentNumberOrder.generateSchedule(studentList);


    }
}
