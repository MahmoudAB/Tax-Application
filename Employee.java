/**
 *
 * @author Mahmoud Abdel Bassets
 */
public class Employee {
    private long empNum;            // Employee number
    private String firstName;       // Employee first name
    private String lastName;        // Employee last name
    private double grossSalary;     // Employee gross salary 
    private double netSalary;       // Employee net salary 
    private double totalDeductions; // Employee total deductions 
    private Ei eiPremium;           // Employee insurance deduction
    private Qpip qpipPremium;       // Employee parental insurance deduction
    private Rrq rrqPremium;         // Employee Quebec pension deduction
    private ProvincialTax provTaxPremium; // Employee provincial income tax
    private FederalTax fedTaxPremium;   // Employee federal income tax
    
    /**
     * Default constructor
     */
    public Employee( ){
        empNum = 0;
        firstName = " ";
        lastName = " ";
        grossSalary = 0.0;
        netSalary = 0.0;
        totalDeductions = 0.0;
        eiPremium = new Ei();
        qpipPremium = new Qpip();
        rrqPremium = new Rrq();
        provTaxPremium = new ProvincialTax();
        fedTaxPremium = new FederalTax();
    }
    
    /******************** Accessor methods ************************************/
    
    /**
     * 
     * @return employee number
     */
    public long getEmpNum(){
        return empNum;
    }
    
    /**
     * 
     * @return employee first name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * 
     * @return employee last name
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * 
     * @return employee gross salary
     */
    public double getGrossSalary(){
        return grossSalary;
    }
    
    /**
     * 
     * @return employee net salary
     */
    public double getNetSalary(){
        return netSalary;
    }
    
    /**
     * 
     * @return empployee total deductions
     */
    public double getTotalDeductions(){
        return totalDeductions;
    }
    
    /**
     * 
     * @return employment insurance premium
     */
    public double getEiPremium(){
        return eiPremium.getEiDeduction();
    }
    
    /**
     * 
     * @return parental insurance premium
     */
    public double getQpipPremium(){
        return qpipPremium.getQpipDeduction();
    }
    
    /**
     * 
     * @return provincial pension plan premium
     */
    public double getRrqPremium(){
        return rrqPremium.getRrqDeduction();
    }
    
    /**
     * 
     * @return provincial tax premium
     */
    public double getProvTaxPremium(){
        return provTaxPremium.getProvTaxDeduction();
    }
    
    /**
     * 
     * @return federal tax premium
     */
    public double getFedTaxPremium(){
        return fedTaxPremium.getFedTaxDeduction();
    }
    
    /******************** Mutator methods *************************************/
    
    /**
     * 
     * @param eNum 
     */
    public void setEmpNum(long eNum){
        empNum = eNum;
    }
    
    /**
     * 
     * @param fName 
     */
    public void setFirstName(String fName){
        firstName = fName;
    }
    
    /**
     * 
     * @param lName 
     */
    public void setLastName(String lName){
        lastName = lName;
    }
    
    /**
     * 
     * @param gSalary 
     */
    public void setGrossSalary(double gSalary){
        grossSalary = gSalary;
    }
    
    
    /**
     * 
     * @param nSalary 
     */
    public void setNetSalary(double nSalary){
        netSalary = nSalary;
    }
    
    /**
     * 
     * @param tDeductions 
     */
    public void setTotalDeductions(double tDeductions){
        totalDeductions = tDeductions;
    }
    
    
    /**
     * 
     * @param ePremium 
     */
    public void setEiPremium(double ePremium){
        eiPremium.setEiDeduction(ePremium);
    }
    
    /**
     * 
     * @param qPremium 
     */
    public void setQpipPremium(double qPremium){
        qpipPremium.setQpipDeduction(qPremium);
    }
    
    /**
     * 
     * @param rPremium 
     */
    public void setRrqPremium(double rPremium){
        rrqPremium.setRrqDeduction(rPremium);
    }
    
    /**
     * 
     * @param pPremium 
     */
    public void setProvTaxPremium(double pPremium){
        provTaxPremium.setProvTaxDeduction(pPremium);
    }
    
    /**
     * 
     * @param fPremium 
     */
    public void setFedTaxPremium(double fPremium){
        fedTaxPremium.setFedTaxDeduction(fPremium);
    }
    
    /******************** Miscelaneous calculation methods ********************/
    
    /**
     * 
     * @param gSalary
     * @return calculated employment insurance premium
     */
    public double calculateEiDeduction(double gSalary){
        return eiPremium.calculateTax(gSalary);
    }
    
    /**
     * 
     * @param gSalary
     * @return calculated parental plan
     */
    public double calculateQpipDeduction(double gSalary){
        return qpipPremium.calculateTax(gSalary);
    }
      
    /**
     * 
     * @param gSalary
     * @return calculated provincial pension plan
     */
    public double calculateRrqDeduction(double gSalary){
        return rrqPremium.calculateTax(gSalary);
    }
    
    /**
     * 
     * @param gSalary
     * @return calculated provincial income tax
     */
    public double calculateProvTaxDeduction(double gSalary){
        return provTaxPremium.calculateTax(gSalary);
    }
    
    /**
     * 
     * @param gSalary
     * @return calculated federal income tax
     */
    public double calculateFedTaxDeduction(double gSalary){
        return fedTaxPremium.calculateTax(gSalary);
    }
      
    /**
     * 
     * @return calculated employee total deductions
     */
    public double calculateTotalDeductions() {
        return (eiPremium.getEiDeduction()+ qpipPremium.getQpipDeduction()+
                rrqPremium.getRrqDeduction()+ 
                provTaxPremium.getProvTaxDeduction() +
                fedTaxPremium.getFedTaxDeduction());
                
    }
    
    /**
     * 
     * @return calculated net salary
     */
    public double calculateNetSalary(){
        return (grossSalary - totalDeductions);
    }
    
    
    /******************** toString method *************************************/
    
    public String toString(){
        return ("\n Employee number : " + empNum +
                "\n First name : " + firstName +
                "\n Last name : " + lastName +
                "\n Gross Salary : " + grossSalary +
                "\n Employment insurance : " + eiPremium.getEiDeduction() +
                "\n Parental insurance : " + qpipPremium.getQpipDeduction() + 
                "\n Quebec pension plan : " + rrqPremium.getRrqDeduction() +
                "\n Provincial tax : " + provTaxPremium.getProvTaxDeduction() +
                "\n Federal tax : " + fedTaxPremium.getFedTaxDeduction() +
                "\n Net salary : " + netSalary);
    }
    
}
