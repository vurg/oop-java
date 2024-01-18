package assignment3;

/** The Employee class is the super-class that facilitates the creation of Employee type objects and its subclasses.*/

public class Employee implements Comparable<Employee> {
    private final String employeeID;
    private String employeeName;
    private double grossSalary;

    public Employee(String employeeID, String employeeName, double grossSalary) throws Exception{

        if(employeeID.isBlank()) {
            throw new Exception("ID cannot be blank.");
        }
        if(employeeName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        if(grossSalary <= 0.0){
            throw new Exception("Salary must be greater than zero.");
        }
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.grossSalary = Calc.truncate(grossSalary);
    }

    public String toString(){
        String employeeTxt = String.format("%s's gross salary is %.2f SEK per month.", this.employeeName, getGrossSalary());
        return employeeTxt;
    }

    //Setter for employee gross salary.
    public void updateGrossSalary(double newGrossSalary) throws Exception{
        if(newGrossSalary <= 0.0){
            throw new Exception("Salary must be greater than zero.");
        }
        this.grossSalary = Calc.truncate(newGrossSalary);
    }

    //Setter for employee name.
    public void updateName(String newName) throws Exception{
        if(newName.isBlank()){
            throw new Exception("Name cannot be blank.");
        }
        this.employeeName = newName;
    }

    //Gets employee salary after taxation.
    public double getNetSalary(){
        double netSalary = this.grossSalary - this.grossSalary * 0.1;
        return Calc.truncate(netSalary);
    }

    //getRawSalary returns salary without bonuses.
    public double getRawSalary(){return this.grossSalary;}

    //getGrossSalary is overridden in the subclasses to include salary modifiers such as bonuses.
    public double getGrossSalary(){return this.grossSalary;}

    public String getEmployeeName(){return this.employeeName;}

    public String getEmployeeID(){return this.employeeID;}

    //Compares Employees based on gross salary. Implements Comparable interface.
    @Override
    public int compareTo(Employee otherEmployee) {

        double thisGrossSalary = getGrossSalary();
        double otherGrossSalary = otherEmployee.getGrossSalary();

        if(thisGrossSalary == otherGrossSalary){
            return 0;
        }else if(thisGrossSalary > otherGrossSalary){
            return 1;
        }else{ // thisGrossSalary < otherGrossSalary
            return -1;
        }
    }
}
