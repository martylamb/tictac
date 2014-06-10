package tictac;

/**
 *
 * @author mlamb
 */
public class Helper {
    
    public static String escape(Object o) {
        return o == null ? "" : o.toString();
    }
}
