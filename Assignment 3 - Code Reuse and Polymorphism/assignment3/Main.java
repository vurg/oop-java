package assignment3;

public class Main{
    public static void main(String[] args) {
        Company netflix = new Company();

        try {
            netflix.createEmployee("Emp1", "Elektra", 35000.50, "MSc", "Business");       // G: 47000.60; N: 37600.48
            netflix.createEmployee("Emp2", "Blanca", 45000.00, "PhD", "Human Resources"); // G: 65750.00; N: 45450.00
            netflix.createEmployee("Emp3", "Pray Tell", 25000.25, "BSc");                 // G: 27500.27; N: 24750.24
            netflix.createEmployee("Emp4", "Lulu", 20000.00, 9);                          // G: 21000.00; N: 21000.00
            netflix.createEmployee("Emp5", "Angel", 28500.10, 7);                         // G: 28500.10; N: 28500.10
            netflix.createEmployee("Emp6", "Candy", 35000.50, 4);                         // G:     0.00; N:     0.00
            netflix.createEmployee("Emp7", "Ricky", 23500.00);                            // G: 23500.00; N: 21150.00
            netflix.createEmployee("Emp8", "Damon", 22100.00);                            // G: 22100.00; N: 19890.00

            System.out.println(netflix.printAllEmployees());

            System.out.println(netflix.getNetSalary("Emp1"));
            System.out.println(netflix.getNetSalary("Emp2"));
            System.out.println(netflix.getNetSalary("Emp3"));
            System.out.println(netflix.getNetSalary("Emp4"));
            System.out.println(netflix.getNetSalary("Emp5"));
            System.out.println(netflix.getNetSalary("Emp6"));
            System.out.println(netflix.getNetSalary("Emp7"));
            System.out.println(netflix.getNetSalary("Emp8"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
