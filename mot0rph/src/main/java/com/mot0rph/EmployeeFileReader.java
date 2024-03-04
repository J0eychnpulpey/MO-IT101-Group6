package com.mot0rph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeFileReader {
    public static void main(String[] args) {
    }

    public Map<String, Long> calculateEmployeeHours(String empId) {
        Map<String, Long> employeeHours = new HashMap<>();
        String line;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String filePath = "/home/johnpaul/Documents/mot0rph/mot0rph/src/main/java/com/resources/Attendancerecord - Sheet1.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(empId)) {
                    Date date = format.parse(values[2]);
                    employeeHours.put(values[0], employeeHours.getOrDefault(values[0], 0L) + date.getTime());
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return employeeHours;
        

    }
}
