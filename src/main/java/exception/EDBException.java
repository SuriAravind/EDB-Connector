package exception;

/**
 * Created by Suriyanarayanan K
 * on 08/03/21 11:23 AM.
 */
public class EDBException extends Exception {
    public EDBException(String s) {
        super(s);
        System.err.println(s);
    }
}
