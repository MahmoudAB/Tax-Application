/**
 *
 * @author Mahmoud Abdel Basset
 */
public class Ei extends Deductions {
    private final double EIRATE = 1.53;             // Rate per $100 of income
    private final double MAXEI = 743.58;            // Maximum EI deduction
    private final double MAXEISALARY = 48600.00;   // Maximum deductible salary
    private double eiDeduction;                     // EI deduction
    
    /******************** Constructors ****************************************/
    
    /**
     * Default constructor
     */
    public Ei(){
        eiDeduction = 0.0;
    }
    
    /******************** Accessor methods ************************************/
    
    /**
     * 
     * @return EI deduction
     */
    public double getEiDeduction(){
        return eiDeduction;
    }
    
    /******************** Mutator methods *************************************/
    
    /**
     * 
     * @param eDeduction 
     */
    public void setEiDeduction(double eDeduction){
        eiDeduction = eDeduction;
    }
    
    /******************* Calculation methods **********************************/
    
    /**
     * 
     * @param gSalary
     * @return employee insurance deduction
     */
    public double calculateTax(double gSalary){
        if (gSalary > MAXEISALARY)
            return MAXEI;
        else
            return (gSalary/100*EIRATE);
        
    }
}
