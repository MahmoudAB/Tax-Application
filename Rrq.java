/**
 *
 * @author Mahmoud Abdel Basset 
 */
public class Rrq extends Deductions{
    private final double RRQRATE = 0.05175;         // RRQ rate
    private final double MAXRRQ = 2535.75;          // Maximum deduction
    private final double MAXRRQSALARY = 52500.00;   // Maximum deductible salary
    private double rrqDeduction;                   // RRQ deduction
    
    /******************* Constructors *****************************************/
    
    /**
     * Default constructor
     */
    public Rrq(){
        rrqDeduction = 0.0;
    }
    
    /******************* Accessor methods *************************************/
    
    /**
     * 
     * @return provincial pension deduction
     */
    public double getRrqDeduction(){
        return rrqDeduction;
    }
    
    /******************* Mutator methods **************************************/
    
    /**
     * 
     * @param rDeduction 
     */
    public void setRrqDeduction(double rDeduction){
        rrqDeduction = rDeduction;
    }
    
    /******************* Calculation methods **********************************/
    
    /**
     * 
     * @param gSalary
     * @return provincial pension plan deduction
     */
    public double calculateTax(double gSalary){
        double rrqDeduct;
        
        rrqDeduct = (gSalary * RRQRATE);
        if (rrqDeduct > MAXRRQ)
            return MAXRRQ;
        else
            return rrqDeduct;
    }
}
