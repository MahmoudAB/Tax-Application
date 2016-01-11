/**
 *
 * @author Mahmoud Abdel Basset
 */
public class MinimumWageException extends Exception {

    /**
     * Creates a new instance of <code>MinimumWageException</code> without
     * detail message.
     */
    public MinimumWageException() {
        super("Invalid minimum wage");
    }

    /**
     * Constructs an instance of <code>MinimumWageException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MinimumWageException(String msg) {
        super(msg);
    }
}
