package com.unitedcoder.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author : user
 * @created : 24.10.2023,17:05
 * @Email :aliyeidiris@gmail.com
 **/
public class LoggerForProperties {

    final static Logger logger = Logger.getLogger(LoggerForProperties.class);
    public static void main(String[] args) {
        LoggerForProperties loggerForProperties = new LoggerForProperties();
        BasicConfigurator.configure();
        loggerForProperties.createApplicationLog("Selenium Master Log Test");

    }

    public void createApplicationLog(String parameter) {

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);
        logger.info("This is info :" + parameter);
    }

}
