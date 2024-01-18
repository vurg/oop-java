package assignment3;

/** Intern is a sub-class of Employee. */

public class Intern extends Employee{
    private int gpa;
    public Intern(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception{
        super(employeeID, employeeName, grossSalary);
        if(gpa <0 || gpa > 10){
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }
        this.gpa = gpa;
    }

    //Gets interns gross salary with GPA modifier.
    @Override
    public double getGrossSalary() {
        double grossSalary = 0.0;
        if(this.gpa <= 5){
            grossSalary = 0.0;
        }else if(this.gpa > 5 && this.gpa < 8){
            grossSalary = getRawSalary();
        }else if(this.gpa >= 8){
            grossSalary = getRawSalary() + 1000.00;
        }
        return Calc.truncate(grossSalary);
    }

    public String toString(){
        String internTxt = String.format("%s's gross salary is %.2f SEK per month. GPA: %d", this.getEmployeeName(), this.getGrossSalary(), this.gpa);
        return internTxt;
    }

    //Setter for intern GPA.
    public void updateGPA(int newGPA) throws Exception{
        if(newGPA <0 || newGPA > 10){
            throw new Exception(newGPA + " outside range. Must be between 0-10.");
        }
        this.gpa = newGPA;
    }

    //Getter for intern salary.
    public double getNetSalary(){
        return this.getGrossSalary();
    }
}
