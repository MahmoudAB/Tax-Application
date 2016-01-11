import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author Mahmoud Abdel Basset
 */
public class Payroll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MinimumWageException {
        Scanner keyboard = new Scanner(System.in);  // Keyboard input
        Scanner payrollFile = null;                 // Input file
        PrintWriter payrollReportFile = null;       // Report file
        PrintWriter payrollErrorFile = null;        // Error file
        String payrollLine = null;                  // Payroll file input line
        String [] payrollFields;                    // Separate input fields
        long empNumber;                             // Employee number
        String empFirstName;                        // Employee first name
        String empLastName;                         // Employee last name
        double empHours;                            // Employee hours worked
        double empWage;                             // Employee hourly wage
        double empSalary;                           // Employee gross salary
        int numberOfLines;                          // Number of input lines
        int numberOfErrorLines;                     // Number of error lines
        
        final double MINWAGE = 10.35;               // Minimum wage
        final double NUMBEROFWEEKS = 52;            // Number of pay periods
        
        Employee [] empArray = new Employee[100];   // Array of employees
        // Initialize each employee object
        for(int i =0; i < empArray.length; i++)
            empArray[i] = new Employee( ); 
        
        // Open payroll file
        try{
            System.out.println("Opening file payroll.txt\n");
            payrollFile = new Scanner(new FileInputStream("payroll.txt"));  
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening the file payroll.txt.");
            System.exit(0);
        }
        
        // Open error file
        try{
            payrollErrorFile = new PrintWriter(new FileOutputStream(
                                               "payrollError.txt"));            
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening the file payrollError.txt.");
            System.exit(0);
        }
        
        // Reading input payroll file into employee array
        System.out.println("Reading file payroll.txt\n");
        System.out.println("     Error lines found in file payroll.txt\n");
        
        numberOfLines = 0; 
        numberOfErrorLines = 0;
        while (payrollFile.hasNextLine()){  // while not end of file
            try{
                payrollLine = payrollFile.nextLine();   // Read an input line
                payrollFields = payrollLine.split(" "); // Tokenize input line
                
                // Convert each input field to appropriate type
                empNumber = Long.parseLong(payrollFields[0]);
                empFirstName = payrollFields[1];
                empLastName = payrollFields[2];
                empHours = Double.parseDouble(payrollFields[3]);
                empWage = Double.parseDouble(payrollFields[4]);
                
                // Check minimum wage
                if (empWage < MINWAGE)
                    throw new MinimumWageException();
                
                // Calculate gross salary
                empSalary = empHours * empWage * NUMBEROFWEEKS;
                  
                // Save input fields in employee array
                empArray[numberOfLines].setEmpNum(empNumber);
                empArray[numberOfLines].setFirstName(empFirstName);
                empArray[numberOfLines].setLastName(empLastName);
                empArray[numberOfLines].setGrossSalary(empSalary);
                   
                // Calculate deductions
                empArray[numberOfLines].setEiPremium(
                  empArray[numberOfLines].calculateEiDeduction(empSalary));
                empArray[numberOfLines].setQpipPremium(
                  empArray[numberOfLines].calculateQpipDeduction(empSalary));
                empArray[numberOfLines].setRrqPremium(
                  empArray[numberOfLines].calculateRrqDeduction(empSalary));
                empArray[numberOfLines].setProvTaxPremium(
                  empArray[numberOfLines].calculateProvTaxDeduction(empSalary));
                empArray[numberOfLines].setFedTaxPremium(
                  empArray[numberOfLines].calculateFedTaxDeduction(empSalary));
              
                // Calculate total deductions
                empArray[numberOfLines].setTotalDeductions(
                    empArray[numberOfLines].calculateTotalDeductions());
                
                // Calculate net salary
                empArray[numberOfLines].setNetSalary(
                    empArray[numberOfLines].calculateNetSalary());
                
                numberOfLines++;    // Increment number of valid lines
              
            }
            catch(NumberFormatException e){ // Invalid input field type
               numberOfErrorLines ++;
               System.out.println("     " + payrollLine + " " + e.getMessage());
               payrollErrorFile.println(payrollLine + " " + e.getMessage());
            }
            catch(MinimumWageException e){  // Invalid minimum hourly wage
               numberOfErrorLines ++;
               System.out.println("     " + payrollLine + " " + e.getMessage());
               payrollErrorFile.println(payrollLine + " " + e.getMessage());
            }
                                     
        }
        
        // Print misceleanous messages
        System.out.println("\n     All deductions calculated");        
        System.out.println("\n     " + (numberOfLines + numberOfErrorLines) + 
                            " lines read from payroll file");
        System.out.println("\n     " + numberOfErrorLines + 
                            " lines written to error file\n");
        System.out.println("Writing report file\n");
        
         // Open report file
        try{
            payrollReportFile = new PrintWriter(new FileOutputStream(
                                               "payrollReport.txt"));            
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening the file payrollReport.txt.");
            System.exit(0);
        }
        
        // Print report
        System.out.printf("%56s", "Harbour Industries");
        System.out.println();
        System.out.printf("%56s", "------------------");
        System.out.println("\n\n");
        System.out.printf("%-9s%-18s%-18s%-15s%-15s%-15s", "Number", 
                          "First Name", "Last Name", "Gross Salary", 
                          "Deductions", "Net Salary ");
        System.out.println();
        System.out.println("---------------------------------------------------"
                            + "------------------------------------");
        
        payrollReportFile.printf("%56s", "Harbour Industries");
        payrollReportFile.println();
        payrollReportFile.printf("%56s", "------------------");
        payrollReportFile.println("\n\n");
        payrollReportFile.printf("%-9s%-18s%-18s%-15s%-15s%-15s", "Number", 
                                 "First Name", "Last Name", "Gross Salary", 
                                 "Deductions", "Net Salary ");
        payrollReportFile.println();
        payrollReportFile.println("-------------------------------------------"
                              + "--------------------------------------------");
        for (int i=0; i < numberOfLines /*empArray.length*/; i++) {
            System.out.printf("%5d%4s", empArray[i].getEmpNum(), " ");
            System.out.printf("%-15s%3s", empArray[i].getFirstName(), " ");
            System.out.printf("%-15s%3s", empArray[i].getLastName(), " ");
            System.out.printf("%-9.2f%6s", empArray[i].getGrossSalary(), " ");
            System.out.printf("%-9.2f%6s", empArray[i].getTotalDeductions(), " ");
            System.out.printf("%-9.2f%6s", empArray[i].getNetSalary(), " ");
            System.out.println("");
            
            payrollReportFile.printf("%5d%4s", empArray[i].getEmpNum(), " ");
            payrollReportFile.printf("%-15s%3s", empArray[i].getFirstName(), " ");
            payrollReportFile.printf("%-15s%3s", empArray[i].getLastName(), " ");
            payrollReportFile.printf("%-9.2f%6s", empArray[i].getGrossSalary(), " ");
            payrollReportFile.printf("%-9.2f%6s", empArray[i].getTotalDeductions(), " ");
            payrollReportFile.printf("%-9.2f%6s", empArray[i].getNetSalary(), " ");
            payrollReportFile.println();
        }

        // Close files
        payrollFile.close();
        payrollErrorFile.close();
        payrollReportFile.close();
    }
    
}
