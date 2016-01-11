/**
 *
 * @author Mahmoud Abdel Basset
 */
public class ProvincialTax extends Deductions{
    private final double PROVTAXRATE1 = 0.16;       // Rate for income < 41495
    private final double PROVTAXRATE2 = 0.20;       // Rate for income < 82895
    private final double PROVTAXRATE3 = 0.24;       // Rate for income < 100970
    private final double PROVTAXRATE4 = 0.2575;     // Rate for income > 100970
    private final double MAXPROVTAX1 = 41495.00 * PROVTAXRATE1;
    private final double MAXPROVTAX2 = (82985.00 - 41495.00) * PROVTAXRATE2;
    private final double MAXPROVTAX3 = (100970.00 - 82985.00) * PROVTAXRATE3;
    private final double MAXPROVTAXSALARY1 = 41495.00;
    private final double MAXPROVTAXSALARY2 = 82985.00;
    private final double MAXPROVTAXSALARY3 = 100970.00;
    
    private double provTaxDeduction;                // Provincial tax deduction
    
    /******************** Constructors ****************************************/
    
    /**
     * Default constructor
     */
    public ProvincialTax(){
        provTaxDeduction = 0.0;
    }
    
    /******************** Accessor methods ************************************/
    
    /**
     * 
     * @return provincial tax deduction 
     */
    public double getProvTaxDeduction(){
        return provTaxDeduction;
    }
    
    /******************** Mutator methods *************************************/
    
    /**
     * 
     * @param pDeduction 
     */
    public void setProvTaxDeduction(double pDeduction){
        provTaxDeduction = pDeduction;
    }
    
    /******************** Calculation methods *********************************/
    
    /**
     * 
     * @param gSalary
     * @return provincial tax deduction
     */
    public double calculateTax(double gSalary){
        double provTaxDeduct;
        
        if(gSalary > MAXPROVTAXSALARY3) { 
            provTaxDeduct = MAXPROVTAX1 + MAXPROVTAX2 + MAXPROVTAX3 +
                            ((gSalary - MAXPROVTAXSALARY3) * PROVTAXRATE4);
        }
        else {
            if (gSalary > MAXPROVTAXSALARY2) {
                provTaxDeduct = MAXPROVTAX1 + MAXPROVTAX2 +
                                ((gSalary - MAXPROVTAXSALARY2) * PROVTAXRATE3);
            }
            else {
                if (gSalary > MAXPROVTAXSALARY1){
                    provTaxDeduct = MAXPROVTAX1 + 
                            ((gSalary - MAXPROVTAXSALARY1) * PROVTAXRATE2);
                }
                else {
                    provTaxDeduct = gSalary * PROVTAXRATE1;
                }
            }
        }
        return provTaxDeduct;   
    }
}
