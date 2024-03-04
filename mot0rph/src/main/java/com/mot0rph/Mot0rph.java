
package com.mot0rph;



import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author johnpaul.P
 */
public class Mot0rph {

        // User Interface 
        public static void main(String[] args) throws IOException, CsvException {
        System.out.println("____________________________________________________________________");
        System.out.println("#########$ M0torPH Payroll Main Menu by Group 6 A1102 $ ###########|");
        System.out.println("                                                                   |");
        System.out.println("[1]: View Employee Profile                                         |");
        System.out.println("[2]: Calculate Net Salary                                          |");  
        System.out.println("___________________________________________________________________|"); 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Type the number: ");
        // takes input from the keyboard
        String option = input.nextLine();
        // prints the option
        // System.out.println("You entered option number: " + option);
        processOption(option);
        // closes the scanner
        input.close();

}       // Conditional statement
        private static void processOption(String option) throws IOException, CsvException {
            //Used conditional branch "switch" statement
            switch (option) {
                case "1":
                    processEmployeeID();
                   break;
                case "2":
                    calculateNetSalary();
                   break;

            
                 default:
                   
            }
        
    }
        //for case "1"
 //method that has "void" signature doesn't return a data type
private static void processEmployeeID() {
    EmployeeModel employeeModel = new EmployeeModel();
    Scanner input = new Scanner(System.in);
    System.out.println("___________________________________________________________");
    System.out.print("Enter the employee ID: ");
    // the empId is the variable that will scan the EmpNo (Employee Id) in EmployeeModel.java
    String empId = input.nextLine(); 

    Employee employee = employeeModel.findEmployeeById(empId);

    input.close();

     // if-else conditional statement 
    if (employee != null) {
        System.out.println("First Name & Last Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Birthday: " + employee.getBirthday());
        System.out.println("Address: " + employee.getAddress());
        System.out.println("Phone #: " + employee.getPhoneNo());
        System.out.println("SSS #: " + employee.getSssNo());
        System.out.println("PhilHealth: " + employee.getPhilHealthNo());
        System.out.println("Tin Number: " + employee.getTinNo());
        System.out.println("PagIbig #: " + employee.getPagibigNo());
        System.out.println("Status: " + employee.getStatus());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Supervisor: " + employee.getSupervisor());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Rice Subsidy: " + employee.getRiceSubsidy());
        System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
        System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
        System.out.println("SemiMonthlyRate: " + employee.getSemiMonthlyRate());
        System.out.println("HourlyRate: " + employee.getHourlyRate());
    } else {
        System.out.println("Employee not found.");
    }
}

private static void calculateNetSalary() {
    EmployeeModel employeeModel = new EmployeeModel();
    Scanner input = new Scanner(System.in);
    System.out.println("___________________________________________________________|");
    System.out.print("Enter the employee ID: ");
    String empId = input.nextLine();

    Employee employee = employeeModel.findEmployeeById(empId);

    input.close();

    if (employee != null) {
        
        System.out.println("Fullname: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Rice Subsidy: " + employee.getRiceSubsidy());
        System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
        System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
        System.out.println("SemiMonthlyRate: " + employee.getSemiMonthlyRate());
        System.out.println("HourlyRate: " + employee.getHourlyRate());

        double grossPay = employee.getBasicSalary();

       
        EmployeeFileReader employeeFileReader = new EmployeeFileReader();
        Map<String, Long> employeeHours = employeeFileReader.calculateEmployeeHours(empId);
        

        Long totalHours = employeeHours.getOrDefault(empId, 0L) / (1000 * 60 * 60);
        double totalHoursfinal = totalHours; 

        grossPay = totalHoursfinal * employee.getHourlyRate();

        SalaryDeductions deductionsCalculator = new SalaryDeductions();

        double totalAllowances = employee.getRiceSubsidy() +
                employee.getPhoneAllowance() +
                employee.getClothingAllowance();

        double sssDeduction = deductionsCalculator.getSSSdeduction(grossPay);
        double philhealthDeduction = deductionsCalculator.getPhilHealthDeduction(grossPay);
        double pagibigDeduction = deductionsCalculator.getPagibigDeduction(grossPay);

        double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction;
        double taxableIncome = grossPay - totalDeductions;

        double withholdingTax = deductionsCalculator.getWithholdingTax(taxableIncome);
        double netSalary = taxableIncome - withholdingTax;

        double finalTotal = netSalary + totalAllowances;

        System.out.println("___________________________________________________________|");
        System.out.println("Your Totalhoursworked base on Attendance Record: " + totalHours);
        System.out.println("___________________________________________________________|");
        System.out.println("SSS CONTRIBUTION: " + sssDeduction);
        System.out.println("PHILHEALTH: " + philhealthDeduction);
        System.out.println("PAG IBIG: " + pagibigDeduction);
        System.out.println("TOTAL DEDUCTION: " + totalDeductions);
        System.out.println("TAXABLE INCOME (GrossSalary - Total Deduction): " + taxableIncome);
        System.out.println("WITHHOLDING TAX: " + withholdingTax);
        System.out.println("AFTER TAXES: " + netSalary);
        System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
        System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
        System.out.println("Rice Subsidy: " + employee.getRiceSubsidy());
        System.out.println("NET PAY (Net Salary + Allowances): " + finalTotal);
    } else {
        System.out.println("Employee not found");
    }
}
}




