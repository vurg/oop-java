package assignment3;

/** Director is a sub-class of Manager.*/

public class Director extends Manager{
    private String department;
    public Director(String employeeID, String employeeName, double grossSalary, String degree, String department) throws Exception{
        super(employeeID, employeeName, grossSalary, degree);
        if(!department.equals("Business") && !department.equals("Human Resources") && !department.equals("Technical")){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.department = department;
    }

    public String toString(){
        String directorTxt = String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", getDegree(), getEmployeeName(), getGrossSalary(), this.department);
        return directorTxt;
    }

    //Updates Director department.
    public void updateDepartment(String newDept) throws Exception{
        if(!newDept.equals("Business") && !newDept.equals("Human Resources") && !newDept.equals("Technical")){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.department = newDept;
    }

    //Gets Director gross salary and adds department bonus.
    public double getGrossSalary() {
        double grossSalary = super.getGrossSalary() + 5000.00;
        return Calc.truncate(grossSalary);
    }

    //Gets Director net salary. Calculates on gross salary with bonus and subtracts tax.
    public double getNetSalary(){
        double grossSalary = getGrossSalary();
        double netSalary = 0.00;

        if (grossSalary < 30000.00){
            netSalary = 0.9 * grossSalary;
        }else if(grossSalary >= 30000.00 && grossSalary <= 50000.00) {
            netSalary = 0.8 * grossSalary;
        }else if(grossSalary >50000.00){
            netSalary = grossSalary - 0.4 * (grossSalary - 30000.00) - 0.2 * 30000.00;
        }
        return Calc.truncate(netSalary);
    }

    public String getDepartment(){return this.department;}
}
