package net.jonathan.jboss.slf4j;

/*
 * @(#)MXLogger.java    0.1.3   03/16/2015
 */

import org.slf4j.Logger;
import org.slf4j.Marker;

import org.slf4j.ext.XLogger;

/**
 * An extension of the SLF4J extended
 * logger that appends a marker to
 * the end of the message.
 * Created to compensate for the 
 * apparent lack of support for
 * markers in the built-in JBoss
 * logging.
 * Creation date: 3/16/15 11:03 AM
 *
 * @author	Jonathan Parker
 * @version     0.1.3
 * @since	0.1.3
 */
final class MXLogger extends XLogger {
    /** True when caller class and method names are to be included in the message text. */
    private boolean includeCallerInfo;
    
    /**
     * A constructor that
     * takes a logger.
     * 
     * @param   logger  org.slf4j.Logger
     */
    MXLogger(final Logger logger) {
        super(logger);
        
        this.includeCallerInfo = true;
    }

    /**
     * A constructor that
     * takes a logger and
     * the include caller
     * info status.
     * 
     * @param   logger              org.slf4j.Logger
     * @param   includeCallerInfo   boolean
     * @since                       0.1.4
     */
    MXLogger(final Logger logger, final boolean includeCallerInfo) {
        super(logger);
        
        this.includeCallerInfo = includeCallerInfo;
    }

    /**
     * Method to return true when
     * the caller info is to be
     * included in message texts.
     * 
     * @return  boolean
     * @since   0.1.4
     */
    boolean isIncludeCallerInfo() {
        return this.includeCallerInfo;
    }

    /**
     * Method to set the include
     * caller info status.
     * 
     * @param   includeCallerInfo   boolean
     * @since                       0.1.4
     */
    void setIncludeCallerInfo(final boolean includeCallerInfo) {
        this.includeCallerInfo = includeCallerInfo;
    }

    /**
     * Write a debug message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void debug(final Marker marker, final String message) {
        String callerInfo = getCallerInfo();

        super.debug(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a debug message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg     java.lang.Object
     */
    @Override
    public void debug(final Marker marker, final String format, final Object arg) {
        String callerInfo = getCallerInfo();

        super.debug(format, arg.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a debug message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg1    java.lang.Object
     * @param   arg2    java.lang.Object
     */
    @Override
    public void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
        String callerInfo = getCallerInfo();

        super.debug(format, arg1, arg2.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a debug message.
     * 
     * @param   marker      org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     */
    @Override
    public void debug(final Marker marker, final String format, final Object... argArray) {
        String callerInfo = getCallerInfo();

        argArray[argArray.length - 1] = argArray[argArray.length - 1].toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]");
        
        super.debug(format, argArray);
        
        callerInfo = null;
    }

    /**
     * Write a debug message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     * @param   t       java.lang.Throwable
     */
    @Override
    public void debug(final Marker marker, final String message, final Throwable t) {
        String callerInfo = getCallerInfo();

        super.debug(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"), t);
      
        callerInfo = null;
    }

    /**
     * Write an error message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void error(final Marker marker, final String message) {
        String callerInfo = getCallerInfo();

        super.error(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
    
        callerInfo = null;
    }

    /**
     * Write an error message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg     java.lang.Object
     */
    @Override
    public void error(final Marker marker, final String format, final Object arg) {
        String callerInfo = getCallerInfo();

        super.error(format, arg.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write an error message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg1    java.lang.Object
     * @param   arg2    java.lang.Object
     */
    @Override
    public void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
        String callerInfo = getCallerInfo();

        super.error(format, arg1, arg2.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write an error message.
     * 
     * @param   marker      org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     */
    @Override
    public void error(final Marker marker, final String format, final Object... argArray) {
        String callerInfo = getCallerInfo();

        argArray[argArray.length - 1] = argArray[argArray.length - 1].toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]");

        super.error(format, argArray);
        
        callerInfo = null;
    }

    /**
     * Write an error message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     * @param   t       java.lang.Throwable
     */
    @Override
    public void error(final Marker marker, final String message, final Throwable t) {
        String callerInfo = getCallerInfo();

        super.error(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"), t);
        
        callerInfo = null;
    }

    /**
     * Write an info message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void info(final Marker marker, final String message) {
        String callerInfo = getCallerInfo();
        
        super.info(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write an info message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg     java.lang.Object
     */
    @Override
    public void info(final Marker marker, final String format, final Object arg) {
        String callerInfo = getCallerInfo();
        
        super.info(format, arg.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write an info message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg1    java.lang.Object
     * @param   arg2    java.lang.Object
     */
    @Override
    public void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
        String callerInfo = getCallerInfo();
        
        super.info(format, arg1, arg2.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write an info message.
     * 
     * @param   marker      org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     */
    @Override
    public void info(final Marker marker, final String format, final Object... argArray) {
        String callerInfo = getCallerInfo();

        argArray[argArray.length - 1] = argArray[argArray.length - 1].toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]");

        super.info(format, argArray);
        
        callerInfo = null;
    }

    /**
     * Write an info message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     * @param   t       java.lang.Throwable
     */
    @Override
    public void info(final Marker marker, final String message, final Throwable t) {
        String callerInfo = getCallerInfo();
        
        super.info(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"), t);
        
        callerInfo = null;
    }

    /**
     * Write a trace message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void trace(final Marker marker, final String message) {
        String callerInfo = getCallerInfo();

        super.trace(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a trace message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg     java.lang.Object
     */
    @Override
    public void trace(final Marker marker, final String format, final Object arg) {
        String callerInfo = getCallerInfo();

        super.trace(format, arg.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a trace message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg1    java.lang.Object
     * @param   arg2    java.lang.Object
     */
    @Override
    public void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
        String callerInfo = getCallerInfo();

        super.trace(format, arg1, arg2.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a trace message.
     * 
     * @param   marker      org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     */
    @Override
    public void trace(final Marker marker, final String format, final Object... argArray) {
        String callerInfo = getCallerInfo();

        argArray[argArray.length - 1] = argArray[argArray.length - 1].toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]");

        super.trace(format, argArray);
        
        callerInfo = null;
    }

    /**
     * Write a trace message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     * @param   t       java.lang.Throwable
     */
    @Override
    public void trace(final Marker marker, final String message, final Throwable t) {
        String callerInfo = getCallerInfo();

        super.trace(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"), t);
        
        callerInfo = null;
    }

    /**
     * Write a warning message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void warn(final Marker marker, final String message) {
        String callerInfo = getCallerInfo();

        super.warn(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }
    
    /**
     * Write a warning message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg     java.lang.Object
     */
    @Override
    public void warn(final Marker marker, final String format, final Object arg) {
        String callerInfo = getCallerInfo();

        super.warn(format, arg.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a warning message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   format  java.lang.String
     * @param   arg1    java.lang.Object
     * @param   arg2    java.lang.Object
     */
    @Override
    public void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
        String callerInfo = getCallerInfo();

        super.warn(format, arg1, arg2.toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"));
        
        callerInfo = null;
    }

    /**
     * Write a warning message.
     * 
     * @param   marker      org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     */
    @Override
    public void warn(final Marker marker, final String format, final Object... argArray) {
        String callerInfo = getCallerInfo();

        argArray[argArray.length - 1] = argArray[argArray.length - 1].toString().concat(callerInfo).concat(" [").concat(marker.getName()).concat("]");

        super.warn(format, argArray);
        
        callerInfo = null;
    }
    
    /**
     * Write a warning message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     * @param   t       java.lang.Throwable
     */
    @Override
    public void warn(final Marker marker, final String message, final Throwable t) {
        String callerInfo = getCallerInfo();

        super.warn(message.concat(callerInfo).concat(" [").concat(marker.getName()).concat("]"), t);
        
        callerInfo = null;
    }
    
    /**
     * Method to return a string representing
     * the class and method names of the caller in
     * the form [class::method].
     * 
     * @return  java.lang.String
     * @since   0.1.4
     */
    private String getCallerInfo() {
        if (!this.includeCallerInfo)
            return "";
        
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String longClassName = elements[3].getClassName();
        String methodName = elements[3].getMethodName();
        
        elements = null;
        
        String shortClassName = longClassName.substring(longClassName.lastIndexOf(".") + 1);
        
        longClassName = null;
        
        return " [".concat(shortClassName).concat("::").concat(methodName).concat("]");
    }
}
