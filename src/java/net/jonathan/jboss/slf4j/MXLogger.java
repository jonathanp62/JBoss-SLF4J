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
 * Creation date: 3/16/15 11:03 AM
 *
 * @author	Jonathan Parker
 * @version     0.1.3
 * @since	0.1.3
 */
final class MXLogger extends XLogger {    
    /**
     * A constructor that
     * takes a logger.
     * 
     * @param   logger  org.slf4j.Logger
     */
    MXLogger(final Logger logger) {
        super(logger);
    }
    
    /**
     * Write a debug message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void debug(final Marker marker, final String message) {
        super.debug(message.concat(" [").concat(marker.getName()).concat("]"));
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
        super.debug(format, arg.toString().concat(" [").concat(marker.getName()).concat("]"));
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
        super.debug(format, arg1, arg2.toString().concat(" [").concat(marker.getName()).concat("]"));
    }

    /**
     * Write a debug message.
     * 
     * @param   marke       org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     * @todo                Implement the marker
     */
    @Override
    public void debug(final Marker marker, final String format, final Object... argArray) {        
        super.debug(format, argArray);
    }

    /**
     * Write an error message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void error(final Marker marker, final String message) {
        super.error(message.concat(" [").concat(marker.getName()).concat("]"));
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
        super.error(format, arg.toString().concat(" [").concat(marker.getName()).concat("]"));
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
        super.error(format, arg1, arg2.toString().concat(" [").concat(marker.getName()).concat("]"));
    }

    /**
     * Write an error message.
     * 
     * @param   marke       org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     * @todo                Implement the marker
     */
    @Override
    public void error(final Marker marker, final String format, final Object... argArray) {        
        super.error(format, argArray);
    }

    /**
     * Write an info message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void info(final Marker marker, final String message) {
        super.info(message.concat(" [").concat(marker.getName()).concat("]"));
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
        super.info(format, arg.toString().concat(" [").concat(marker.getName()).concat("]"));
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
        super.info(format, arg1, arg2.toString().concat(" [").concat(marker.getName()).concat("]"));
    }

    /**
     * Write an info message.
     * 
     * @param   marke       org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     * @todo                Implement the marker
     */
    @Override
    public void info(final Marker marker, final String format, final Object... argArray) {        
        super.info(format, argArray);
    }

    /**
     * Write a trace message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void trace(final Marker marker, final String message) {
        super.trace(message.concat(" [").concat(marker.getName()).concat("]"));
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
        super.trace(format, arg.toString().concat(" [").concat(marker.getName()).concat("]"));
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
        super.trace(format, arg1, arg2.toString().concat(" [").concat(marker.getName()).concat("]"));
    }

    /**
     * Write a trace message.
     * 
     * @param   marke       org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     * @todo                Implement the marker
     */
    @Override
    public void trace(final Marker marker, final String format, final Object... argArray) {        
        super.trace(format, argArray);
    }

    /**
     * Write a warning message.
     * 
     * @param   marker  org.slf4j.Marker
     * @param   message java.lang.String
     */
    @Override
    public void warn(final Marker marker, final String message) {
        super.warn(message.concat(" [").concat(marker.getName()).concat("]"));
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
        super.warn(format, arg.toString().concat(" [").concat(marker.getName()).concat("]"));
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
        super.warn(format, arg1, arg2.toString().concat(" [").concat(marker.getName()).concat("]"));
    }

    /**
     * Write a warning message.
     * 
     * @param   marke       org.slf4j.Marker
     * @param   format      java.lang.String
     * @param   argArray    java.lang.Object[]
     * @todo                Implement the marker
     */
    @Override
    public void warn(final Marker marker, final String format, final Object... argArray) {        
        super.warn(format, argArray);
    }
}
