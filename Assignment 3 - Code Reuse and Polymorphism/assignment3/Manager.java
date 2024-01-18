package assignment3;

/** The Manager class is a sub-class of Employee and the super-class for Director. */

public class Manager extends Employee{
    private String degree;
    public Manager(String employeeID, String employeeName, double grossSalary, String degree) throws Exception{
        super(employeeID, employeeName, grossSalary);
        if(!degree.equals("BSc") && !degree.equals("MSc") && !degree.equals("PhD")){
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        this.degree = degree;
    }

    public String toString(){
        String managerTxt = String.format("%s %s's gross salary is %.2f SEK per month.", this.degree, this.getEmployeeName(), this.getGrossSalary());
        return managerTxt;
    }

    //Updates Manager degree.
    public void updateDegree(String newDegree) throws Exception{
        if(!newDegree.equals("BSc") && !newDegree.equals("MSc") && !newDegree.equals("PhD")){
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        this.degree = newDegree;
    }

    //Gets Manager gross salary after degree modifier.
    public double getGrossSalary() {
        double grossSalary = 0.0;
        if (this.degree.equals("BSc")) {
            grossSalary = 1.10 * getRawSalary();
        }else if(this.degree.equals("MSc")){
            grossSalary = 1.20 * getRawSalary();
        }else if(this.degree.equals("PhD")){
            grossSalary = 1.35 * getRawSalary();
        }
        return Calc.truncate(grossSalary);
    }

    //Get Manager net salary after degree modifier and taxation.
    public double getNetSalary(){
        double netSalary = this.getGrossSalary() - (getGrossSalary() * 0.1);
        return Calc.truncate(netSalary);
    }

    public String getDegree(){
        return this.degree;
    }
}
