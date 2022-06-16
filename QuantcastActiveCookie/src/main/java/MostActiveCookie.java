import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import picocli.CommandLine;

import static picocli.CommandLine.Option;


/**
 * @author Aditya Aggarwal
 * This file is responsible to initate functionality to get most active cookie
 */
@CommandLine.Command(
        name = "activeCookie",
        description = "It prints most active cookie"
)
public class MostActiveCookie implements Runnable {

    private static final Logger logger = LogManager.getLogger(MostActiveCookie.class.getName());

    //This option is used to get the file name to read data
    @CommandLine.Option(names = "-f")
    static String logFile;

    //This option is to get the date from the user
    @Option(names = "-d")
    static String date;

    public static void main(String[] args) {

        logger.info("Entering method main()");
        new CommandLine(new MostActiveCookie()).execute(args);
        logger.info("Exiting method main()");

    }

    /**
     * This method initiate the process by providing input parameters
     */
    @Override
    public void run() {

        CookiesChecker cookiesChecker = new CookiesChecker();
        //This calls the method to find most active cookies
        if (null != logFile && null != date) {
            cookiesChecker.getMostActiveCookie(logFile, new DateTime(date));
        } else {
            logger.info("Insufficient parameters provided");
        }

    }
}
