package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j2 {
    private static final Logger logger = LogManager.getLogger(TestLog4j2.class);

    public static void main(String[] args) {

        logger.debug("This Will Be Printed On Debug");
        logger.info("This Will Be Printed On Info");
        logger.warn("This Will Be Printed On Warn");
        logger.error("This Will Be Printed On Error");
        logger.fatal("This Will Be Printed On Fatal");

        logger.info("Appending string: {}", "Hello, World");
    }
}
