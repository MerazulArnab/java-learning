import java.util.ArrayList;
import java.util.List;

public class PayrollApp {
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTime("Arnab", "E001", 5000));

        employees.add(new Casual ("John", "E002",30,20));

        for (Employee employee: employees){
            System.out.println(employee.getName()+" Pay: $"+ employee.calculatePay());
        }
    }
}
