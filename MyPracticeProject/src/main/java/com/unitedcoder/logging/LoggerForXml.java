package com.unitedcoder.logging;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author : user
 * @created : 8.12.2023,13:26
 * @Email :aliyeidiris@gmail.com
 **/
public class LoggerForXml {
    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoggerForXml.class.getName());

    public LoggerForXml() {
        DOMConfigurator.configure("/Users/user/IdeaProjects/MyPracticeProject/src/test/resources/log4j2.xml");
    }

    public static void info(String massage) {
        logger.info(massage);
    }

    public static void warn(String massage) {
        logger.warn(massage);
    }

    public static void error(String massage) {
        logger.error(massage);
    }

    public static void debug(String massage) {
        logger.debug(massage);
    }
}
