public class Employee {
    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId){
        this.name = name;
        this.employeeId = employeeId;

    }

    public double calculatePay(){
        return 0;
    }

    public String getName(){
        return name;
    }
}
