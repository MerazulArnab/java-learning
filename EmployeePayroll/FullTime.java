public class FullTime extends Employee{
    private double monthlySalary;

    public FullTime(String name, String employeeId, double monthlySalary){

        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override //Override here means Employee already has calculatePay(), but FullTime wants its own version.
    public double calculatePay(){
        return monthlySalary;
    }
}
