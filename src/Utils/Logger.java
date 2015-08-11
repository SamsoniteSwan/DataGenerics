/*
 * Jeremy Swanson
 * Property of / therein / so forth
 */
package Utils;

/**
 *
 * @author swans_000
 */
public class Logger {
    
    private static int mLevel;
    private static boolean mIsEnabled;
    
    /**Print information to the console if 
     * logger is enabled and level 4+.
     *
     * @param strMessage Text to display in console
     */
    public static void logDebug(String strMessage) {
        if (mIsEnabled && (mLevel >= 4)) {
            System.out.println(strMessage);
        }
    }
    
        /**Print information to the console if 
     * logger is enabled and level 3+.
     *
     * @param strMessage Text to display in console
     */
    public static void logInfo(String strMessage) {
        if (mIsEnabled && (mLevel >= 3)) {
            System.out.println(strMessage);
        }
    }
        /**Print information to the console if 
     * logger is enabled and level 2+.
     *
     * @param strMessage Text to display in console
     */
    public static void logWarning(String strMessage) {
        if (mIsEnabled && (mLevel >= 2)) {
            System.out.println(strMessage);
        }
        
    }
        /**Print information to the console if 
     * logger is enabled and level 1+.
     *
     * @param strMessage Text to display in console
     */
    public static void logError(String strMessage) {
        if (mIsEnabled && (mLevel >= 1)) {
            System.out.println(strMessage);
        }
        
    }
    
    /**
    *Turn logging ON
    */
    public static void enableLogging() {
        mIsEnabled = true;
    }
    /**
     * Turn logging OFF
     */
    public static void disableLogging() {
        mIsEnabled = false;
    }
    
    /**
     * Set log level
     * @param logLevel Set level of logging. Higher level
     * means more logs
     */
    public static void setLogLevel(int logLevel) {
        mLevel = logLevel;
        
    }
    
}
