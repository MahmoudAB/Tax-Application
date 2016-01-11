/**
 *
 * @author Mahmoud Abdel Basset
 */
public class Qpip extends Deductions{
    private final double QPIPRATE = 0.00559;        // QPIP rate
    private final double MAXQPIP = 385.71;          // Maximum deduction
    private final double MAXQPIPSALARY = 69000.00;  // Maximum deductible salary
    private double qpipDeduction;                   // QPIP deduction
    
    /******************** Constructors ****************************************/
    
    /**
     * Default constructor
     */
    public Qpip(){
        qpipDeduction = 0.0;
    }
    
    /******************* Accessor methods *************************************/
    
    /**
     * 
     * @return parental insurance deduction
     */
    public double getQpipDeduction(){
        return qpipDeduction;
    }
    
     /******************* Mutator methods *************************************/
    
    /**
     * 
     * @param qDeduction 
     */
    public void setQpipDeduction(double qDeduction){
        qpipDeduction = qDeduction;
    }
    
     /******************* Calculation methods *********************************/
    
    /**
     * 
     * @param gSalary
     * @return calculated parental insurance deduction
     */
    public double calculateTax(double gSalary){
        if (gSalary > MAXQPIPSALARY)
            return MAXQPIP;
        else
            return (gSalary * QPIPRATE);
    }
}
