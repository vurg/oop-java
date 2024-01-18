package assignment3;

import java.util.*;

/**Company class is the facade class for our employee system. Users interact only with the Company class.*/

public class Company{
    private ArrayList<Employee> employeeList;

    public Company(){
        this.employeeList = new ArrayList<>();
    }

    // Creation of different type of Employees by facade class, Overloaded to accommodate for different attributes.
    // Creates regular Employee.
    public String createEmployee(String eID, String employeeName, double grossSalary) throws Exception{
        checkEqualID(eID);
        Employee newEmployee = new Employee(eID, employeeName, grossSalary);
        this.employeeList.add(newEmployee);
        return String.format("Employee %s was registered successfully.", eID);
    }

    // Creates Manager.
    public String createEmployee(String eID, String employeeName, double grossSalary, String degree) throws Exception{
        checkEqualID(eID);
        Employee newEmployee = new Manager(eID, employeeName, grossSalary, degree);
        this.employeeList.add(newEmployee);
        return String.format("Employee %s was registered successfully.", eID);
    }

    //Creates Director.
    public String createEmployee(String eID, String employeeName, double grossSalary, String degree, String department) throws Exception{
        checkEqualID(eID);
        Employee newEmployee = new Director(eID, employeeName, grossSalary, degree, department);
        this.employeeList.add(newEmployee);
        return String.format("Employee %s was registered successfully.", eID);
    }

    //Creates Intern.
    public String createEmployee(String eID, String employeeName, double grossSalary, int GPA) throws Exception{
        checkEqualID(eID);
        Employee newEmployee = new Intern(eID, employeeName, grossSalary, GPA);
        this.employeeList.add(newEmployee);
        return String.format("Employee %s was registered successfully.", eID);
    }

    //Checks if Employee with same ID is already registered.
    private void checkEqualID(String eID) throws Exception{
        for(Employee checkedEmployee : this.employeeList){
            if(eID.equals(checkedEmployee.getEmployeeID())){
                throw new Exception("Cannot register. ID "+ eID + " is already registered.");
            }
        }
    }

    //Private method that retrieves an Employee based on ID.
    private Employee findEmployee(String eID) throws Exception{
        for (Employee employee: this.employeeList){
            if (employee.getEmployeeID().equals(eID)){
                return employee;
            }
        }
        throw new Exception("Employee " + eID + " was not registered yet.");
    }

    //Removes employee for employee list based on ID.
    public String removeEmployee(String eID) throws Exception{
        this.employeeList.remove(findEmployee(eID));
        return String.format("Employee %s was successfully removed.", eID);
    }

    //Prints toString of employee based on ID.
    public String printEmployee(String eID) throws Exception{
        return findEmployee(eID).toString();
    }

    //Updates gross salary of employee based on ID.
    public String updateGrossSalary(String eID, double newSalary) throws Exception{
        findEmployee(eID).updateGrossSalary(newSalary);
        return String.format("Employee %s was updated successfully", eID);
    }

    //Updates employee name based on ID.
    public String updateEmployeeName(String eID, String newName) throws Exception{
        findEmployee(eID).updateName(newName);
        return String.format("Employee %s was updated successfully", eID);
    }

    //Updates intern GPA based on ID.
    public String updateInternGPA(String eID, int newGPA) throws Exception{
        if(findEmployee(eID) instanceof Intern) {
            ((Intern) findEmployee(eID)).updateGPA(newGPA);
        }
        return String.format("Employee %s was updated successfully", eID);
    }

    //Updates Manager degree based on ID.
    public String updateManagerDegree(String ID, String newDegree) throws Exception{
        if(findEmployee(ID) instanceof Manager){
            ((Manager) findEmployee(ID)).updateDegree(newDegree);
        }
        return String.format("Employee %s was updated successfully", ID);
    }

    //Updates Director department based on ID.
    public String updateDirectorDept(String eID, String newDept) throws Exception{
        if(findEmployee(eID) instanceof Director) {
            ((Director) findEmployee(eID)).updateDepartment(newDept);
        }
        return String.format("Employee %s was updated successfully", eID);
    }

    //Promotes an Employee to Manager.
    public String promoteToManager(String eID, String degree) throws Exception{
        Employee promotedEmployee = findEmployee(eID);
        removeEmployee(eID);
        createEmployee(eID, promotedEmployee.getEmployeeName(), promotedEmployee.getRawSalary(), degree);
        return String.format("%s promoted successfully to Manager.", eID);
    }

    //Promotes an Employee to Director.
    public String promoteToDirector(String eID, String degree, String department) throws Exception{
        Employee promotedEmployee = findEmployee(eID);
        removeEmployee(eID);
        createEmployee(eID, promotedEmployee.getEmployeeName(), promotedEmployee.getRawSalary(), degree, department);
        return String.format("%s promoted successfully to Director.", eID);
    }

    //Promotes an Employee to Intern.
    public String promoteToIntern(String eID, int GPA) throws Exception{
        Employee promotedEmployee = findEmployee(eID);
        removeEmployee(eID);
        createEmployee(eID, promotedEmployee.getEmployeeName(), promotedEmployee.getRawSalary(), GPA);
        return String.format("%s promoted successfully to Intern.", eID);
    }

    //Prints all Employees in the employee list in the order they were added.
    public String printAllEmployees() throws Exception{
        if(this.employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        String message = "All registered employees:" + System.lineSeparator();
        for(Employee employee: this.employeeList){
            message = message + employee + System.lineSeparator();
        }
        return message;
    }

    //Prints all Employees in the employee list sorted by gross salary, in ascending order.
    public String printSortedEmployees() throws Exception{
        if(this.employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        ArrayList<Employee> sortedEmployees = this.employeeList;
        Collections.sort(sortedEmployees);

        String message = "Employees sorted by gross salary (ascending order):" + System.lineSeparator();
        for(Employee employee: sortedEmployees){
            message = message + employee + System.lineSeparator();
        }
        return message;
    }

    //Collect all degrees of Managers/Directors in a Map (HashMap).
    public Map<String, Integer> mapEachDegree() throws Exception{
        if(this.employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        int numPhD = 0;
        int numMSc = 0;
        int numBSc = 0;

        for (Employee employee: this.employeeList) {
            if (employee instanceof Manager) {
                String degree = ((Manager) employee).getDegree();
                if(degree.equals("PhD")){
                    numPhD++;
                }else if(degree.equals("MSc")){
                    numMSc++;
                }else if(degree.equals("BSc")){
                    numBSc++;
                }
            }
        }
        Map<String, Integer> degreeMap = new HashMap<>();
        if (numPhD>0){
            degreeMap.put("PhD", numPhD);
        }
        if (numMSc>0){
            degreeMap.put("MSc", numMSc);
        }
        if (numBSc>0){
            degreeMap.put("BSc", numBSc);
        }
        return degreeMap;
    }

    //Gets net salary for employee based on ID.
    public double getNetSalary(String eID) throws Exception{
        return findEmployee(eID).getNetSalary();
    }

    //Calculates the net salary of all Employees in the employee list.
    public double getTotalNetSalary() throws Exception{
        if(this.employeeList.isEmpty()){
            throw new Exception("No employees registered yet.");
        }
        double totalNetSalary = 0.0;
        for(Employee employee: this.employeeList){
            totalNetSalary = totalNetSalary + employee.getNetSalary();
        }
        return  totalNetSalary;
    }
}
