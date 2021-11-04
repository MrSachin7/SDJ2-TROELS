package StudentOrdering;

import java.util.List;

public class ExamScheduler {
    private OrderStrategy strategy;

    public ExamScheduler(OrderStrategy strategy){
        this.strategy=strategy;
    }
    public void generateSchedule(List<Student> students){
        strategy.orderList(students);
        System.out.println(students);
    }
}
