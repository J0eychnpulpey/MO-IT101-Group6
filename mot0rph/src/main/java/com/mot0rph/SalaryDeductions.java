/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mot0rph;
/**
 * Abstraction
 *Each method hides the specifics of its calculation behind a name, exposing 
 * only how you interact with it (input parameters and the return value).
 * 
 * 


 * @author johnpaul
 */
public class SalaryDeductions {
    
  
    
   double getSSSdeduction(double grossPay) {
    /*
    If the grossPay is 90,000 then the SSS deduction must be 1,125    
     */
       if (grossPay < 3250) {
        return 135.00;
    } else if (grossPay <= 3750) {
        return 157.50;
    } else if (grossPay <= 4250) {
        return 180.00;
    } else if (grossPay <= 4750) {
        return 202.50;
    } else if (grossPay <= 5250) {
        return 225.00;
    } else if (grossPay <= 5750) {
        return 247.50;
    } else if (grossPay <= 6250) {
        return 270.00;
    } else if (grossPay <= 6750) {
        return 292.50;
    } else if (grossPay <= 7250) {
        return 315.00;
    } else if (grossPay <= 7750) {
        return 337.50;
    } else if (grossPay <= 8250) {
        return 360.00;
    } else if (grossPay <= 8750) {
        return 382.50;
    } else if (grossPay <= 9250) {
        return 405.00;
    } else if (grossPay <= 9750) {
        return 427.50;
    } else if (grossPay <= 10250) {
        return 450.00;
    } else if (grossPay <= 10750) {
        return 472.50;
    } else if (grossPay <= 11250) {
        return 495.00;
    } else if (grossPay <= 11750) {
        return 517.50;
    } else if (grossPay <= 12250) {
        return 540.00;
    } else if (grossPay <= 12750) {
        return 562.50;
    } else if (grossPay <= 13250) {
        return 585.00;
    } else if (grossPay <= 13750) {
        return 607.50;
    } else if (grossPay <= 14250) {
        return 630.00;
    } else if (grossPay <= 14750) {
        return 652.50;
    } else if (grossPay <= 15250) {
        return 675.00;
    } else if (grossPay <= 15750) {
        return 697.50;
    } else if (grossPay <= 16250) {
        return 720.00;
    } else if (grossPay <= 16750) {
        return 742.50;
    } else if (grossPay <= 17250) {
        return 765.00;
    } else if (grossPay <= 17750) {
        return 787.50;
    } else if (grossPay <= 18250) {
        return 810.00;
    } else if (grossPay <= 18750) {
        return 832.50;
    } else if (grossPay <= 19250) {
        return 855.00;
    } else if (grossPay <= 19750) {
        return 877.5;
    } else if (grossPay <= 20250) {
        return 900.00;
    } else if (grossPay <= 20750) {
        return 922.50;
    } else if (grossPay <= 21250) {
        return 945.00;
    } else if (grossPay <= 21750) {
        return 967.50;
    } else if (grossPay <= 22250) {
        return 990.00;
    } else if (grossPay <= 22750) {
        return 1012.50;
    } else if (grossPay <= 23250) {
        return 1035.00;
    } else if (grossPay <= 23750) {
        return 1057.50; 
    } else if (grossPay <= 24250) {
        return 1080.00;
    } else if (grossPay <= 24750) {
        return 1102.50;
    } else if (grossPay > 24750) { 
        return 1125.00; 
    }

    // Handle unexpected input
    System.err.println("Error: Gross pay out of SSS table range!");
    return 0.0; 
        
    }   
    
   
  double getPagibigDeduction(double grossPay) {
/*
If the monthly basic salary is atleast 1,000 to 1,500 therefore the employee's contribution rate is 1% the employer is 2%  overall total is 3%
If the monthly basic salary is over 1,500 the employee's contribution rate is 2% and the employer is 2%  the overall total is 2% 
 Let say the employee 1 grossPay is 25,000 then the pagibig deduction is 100  NOTE: The maximum contribution amount is 100.     
*/
    double employeeContributionRate = (grossPay >= 1500) ? 0.02 : 0.01;
    double pagibigContribution= grossPay * employeeContributionRate;

     // Cap at 100 
    return Math.min(pagibigContribution, 100);
}   
      
      
  
    double getPhilHealthDeduction(double grossPay) {
/*
-if the month basic salary  10,000 the premium rate is 3% therefore the monthlyt premium (deduction) would be 300
-if the month basic salary  10,000.001 to 59,999,99 the premium rate is 3% therefore the monthlyt premium (deduction) would be
300 up to 1800
- if the month basic salary  60,000 the premium rate is 3% therefore the monthlyt premium (deduction) would be 1800
  Let say the grossPay is 25,000 therefore  it has 3% premium rate 750 on the other hand the employee share(50%) is 375
  NOTE: Monthly premium contribution payments are equally shared between the employee and employer.      
*/
    double premiumRate = 0.03;
    double maxContribution = 1800.0; 
    double calculatedContribution = grossPay * premiumRate;
    double employeeShare = Math.min(calculatedContribution, maxContribution) / 2;

    return employeeShare; 
}

  
        double getWithholdingTax(double grossSalary) {
            
        double withHoldingTax = 0;
        if (grossSalary > 20833 && grossSalary <= 33333) {
        withHoldingTax = (grossSalary - 20833) * 0.20;  
        } else if (grossSalary > 33333 && grossSalary <= 66666) { 
        withHoldingTax = 2500 + (grossSalary - 33333) * 0.25;  
        } else if (grossSalary > 66666 && grossSalary <= 166666) { 
        withHoldingTax = 10833 + (grossSalary - 66666) * 0.30; 
        } else if (grossSalary > 166666 && grossSalary <= 666666) { 
        withHoldingTax = 40833.33 + (grossSalary - 166666) * 0.32; 
        } else if (grossSalary > 666666) { 
        withHoldingTax = 200833.33 + (grossSalary - 666666) * 0.35; 
        } else { 
        withHoldingTax = 0.0; 
        } 
        return withHoldingTax;
        

    }
   
        
public double getTotalDeductions(double salary) {
    return getSSSdeduction(salary) + 
           getPagibigDeduction(salary) + 
           getPhilHealthDeduction(salary) + 
           getWithholdingTax(salary); // Pass 'salary' here
}
}


        
    


        
        
        
        
