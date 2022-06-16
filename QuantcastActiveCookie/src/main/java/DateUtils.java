import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

/**
 * @author Aditya Aggarwal
 * This class is responsible to perfrom date realted operations
 */
public class DateUtils {

    private static final Logger logger = LogManager.getLogger(CookiesChecker.class.getName());

    /**
     * This method check whether two dates are same or nots
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateSame(DateTime date1, DateTime date2) {

        if (null != date1 && null != date2) {
            return date1.getDayOfMonth() == date2.getDayOfMonth()
                    && date1.getMonthOfYear() == date2.getMonthOfYear()
                    && date1.getYear() == date2.getYear();
        }
        return false;

    }
}
