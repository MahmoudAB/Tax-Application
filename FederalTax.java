/**
 *
 * @author Mahmoud Abdel Basset
 */
public class FederalTax extends Deductions{
    private final double FEDTAXRATE1 = 0.15;       // Rate for income < 43953
    private final double FEDTAXRATE2 = 0.22;       // Rate for income < 87907
    private final double FEDTAXRATE3 = 0.26;       // Rate for income < 136270
    private final double FEDTAXRATE4 = 0.29;     // Rate for income > 136270
    private final double MAXFEDTAX1 = 43953.00 * FEDTAXRATE1;
    private final double MAXFEDTAX2 = (87907.00 - 43954.00) * FEDTAXRATE2;
    private final double MAXFEDTAX3 = (136270.00 - 87907.00) * FEDTAXRATE3;
    private final double MAXFEDTAXSALARY1 = 43954.00;
    private final double MAXFEDTAXSALARY2 = 87907.00;
    private final double MAXFEDTAXSALARY3 = 136270.00;
    
    private double fedTaxDeduction;                // Federal tax deduction
    
    /******************** Constructors ****************************************/
    
    /**
     * Default constructor
     */
    public FederalTax(){
        fedTaxDeduction = 0.0;
    }
    
    /******************** Accessor methods ************************************/
    
    /**
     * 
     * @return federal tax deduction 
     */
    public double getFedTaxDeduction(){
        return fedTaxDeduction;
    }
    
    /******************** Mutator methods *************************************/
    
    /**
     * 
     * @param fDeduction 
     */
    public void setFedTaxDeduction(double fDeduction){
        fedTaxDeduction = fDeduction;
    }
    
    /******************** Calculation methods *********************************/
    
    /**
     * 
     * @param gSalary
     * @return federal tax deduction
     */
    public double calculateTax(double gSalary){
        double fedTaxDeduct;
        
        if(gSalary > MAXFEDTAXSALARY3) { 
            fedTaxDeduct = MAXFEDTAX1 + MAXFEDTAX2 + MAXFEDTAX3 +
                            ((gSalary - MAXFEDTAXSALARY3) * FEDTAXRATE4);
        }
        else {
            if (gSalary > MAXFEDTAXSALARY2) {
                fedTaxDeduct = MAXFEDTAX1 + MAXFEDTAX2 +
                                ((gSalary - MAXFEDTAXSALARY2) * FEDTAXRATE3);
            }
            else {
                if (gSalary > MAXFEDTAXSALARY1){
                    fedTaxDeduct = MAXFEDTAX1 + 
                            ((gSalary - MAXFEDTAXSALARY1) * FEDTAXRATE2);
                }
                else {
                    fedTaxDeduct = gSalary * FEDTAXRATE1;
                }
            }
        }
        return fedTaxDeduct;   
    }
}

