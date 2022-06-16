import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Aditya Aggarwal
 * This class is resposnsible to perfrom operations to find most active cookiess
 */
public class CookiesChecker {

    private static final Logger logger = LogManager.getLogger(CookiesChecker.class.getName());

    /**
     * This method get the most active cookies
     *
     * @param logFile
     * @param date
     */
    public void getMostActiveCookie(String logFile, DateTime date) {

        logger.info("Entering method getMostActiveCookie()");

        //Get all the cookies for given date
        Map<String, Integer> cookieMap = getCookies(logFile, date);

        //Get list of most active cookies
        List<String> mostActiveCookies = cookieMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(cookieMap.values()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        //Print all cookies with most active state
        if (mostActiveCookies.size() > 0) {
            //Print cookies which are mostly active
            mostActiveCookies.forEach(logger::info);
        } else {
            //When no cookie found, log the details.
            logger.debug("No data found for given date");
        }

        logger.info("Exiting method getMostActiveCookie()");

    }

    /**
     * This method reads the cookie log file and returns the cookies active on a given date
     *
     * @param logFile
     * @param date
     * @return
     */
    private Map<String, Integer> getCookies(String logFile, DateTime date) {

        logger.info("Entering method getCookies()");
        Scanner sc = null;
        try {
            sc = new Scanner(new File(logFile));
        } catch (FileNotFoundException e) {
            logger.error("No file found");
            throw new RuntimeException(e);
        }

        sc.nextLine();
        Map<String, Integer> cookieMap = new HashMap<>();

        while (sc.hasNext())  //returns a boolean value
        {
            String cookieLogRow = sc.next();
            if (DateUtils.isDateSame(new DateTime(cookieLogRow.split(",")[1]),
                    new DateTime(date))) {
                String key = cookieLogRow.split(",")[0];

                cookieMap.put(key, cookieMap.containsKey(key) ? cookieMap.get(key) + 1 : 1);
            }
        }

        logger.info("Exiting method getCookies()");
        return cookieMap;

    }
}
