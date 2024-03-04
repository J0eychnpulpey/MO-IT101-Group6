
package com.mot0rph;

/**
 *The Philippines Labor Code sets a standard workweek of 40 hours, with a maximum of 48 hours including overtime. 
 * @author Group 6
 * []: Employees are given a 10-minute grace period. This means that salary deductions will only be applied if they log in 
      from 8:11 onward.
 *
 */
class salaryandTotalhoursworked {

    private static final int STANDARD_WORK_HOURS = 40;
    private static final double OVERTIME_RATE_MULTIPLILER = 1.5; 
    private static final int GRACE_PERIOD_MINUTES = 10;

    public double getsalaryandTotalhoursworked(double hourlyRate, double hoursWorked) {
        double overtimeHours = Math.max(0, hoursWorked - STANDARD_WORK_HOURS);
        double overtimePay = overtimeHours * hourlyRate * OVERTIME_RATE_MULTIPLILER;
        double regularPay = Math.min(hoursWorked, STANDARD_WORK_HOURS) * hourlyRate;
        
        if (hoursWorked > STANDARD_WORK_HOURS && hoursWorked <= STANDARD_WORK_HOURS + GRACE_PERIOD_MINUTES / 60.0) {
            regularPay += (hoursWorked - STANDARD_WORK_HOURS) * hourlyRate;
        }
      
        return regularPay + overtimePay;
    }  

}
      


