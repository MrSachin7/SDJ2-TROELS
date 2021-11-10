package RightSRP;

public class DataAccess {

    private DataBase database; // lets imagine this is able to save to database

    public void saveToDatabase(StudentList studentList){
        database.save(studentList);
    }
}
