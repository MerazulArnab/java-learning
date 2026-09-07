public class Casual extends Employee {

    private double hourlyRate;
    private double hoursWorked;

    public Casual( String name, String employeeId, double hourlyRate, double hoursWorked){
        super(name, employeeId);

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay(){
        return hourlyRate * hoursWorked;
    }
    
}
