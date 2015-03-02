package com.amgen.getResponse.utility;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class GetResponseLog {
	/*
	 * instance variales
	 */
	public static final int FATAL = 5;
	public static final int ERROR = 4;
	public  final int WARN = 3;
	public static final int INFO = 2;
	public static final int DEBUG = 1;
	private Logger log;
	public GetResponseLog (String name)
	{
		log = Logger.getLogger(name);
	}

	public GetResponseLog (Class clazz)
	{
		log = Logger.getLogger(clazz);
	}

	public void log(int level, Object message)
	{
		switch (level) {

		case FATAL:
			log.fatal(message);
			return;
		case ERROR:
			log.error(message);
			return;
		case WARN:
			log.warn(message);
			return;
		case INFO:
			log.info(message);
			return;
		case DEBUG:
			log.debug(message);
			return;

		default:

		}
	}

	public boolean isLogEnabled(int level)
	{

		switch (level) {
		case FATAL:
			return isFatalEnabled();
		case ERROR:
			return isErrorEnabled();
		case WARN:
			return isWarnEnabled();
		case INFO:
			return isInfoEnabled();
		case DEBUG:
			return isDebugEnabled();

		default:
		}
		return false;
	}


	public boolean isDebugEnabled() {

		return log.isEnabledFor(Level.DEBUG);
	}

	private boolean isInfoEnabled() {

		return log.isEnabledFor(Level.INFO);
	}

	private boolean isWarnEnabled() {
		return log.isEnabledFor(Level.WARN);
	}

	private boolean isFatalEnabled() {
		return log.isEnabledFor(Level.FATAL);
	}	

	public boolean isErrorEnabled()
	{
		return log.isEnabledFor(Level.ERROR);
	}

	public void debug(Object message)
	{
		log.debug(message);
	}

	public void debug(Object message, Throwable throwable)
	{
		log.debug(message, throwable);
	}

	public void error(Object message, Throwable throwable)
	{
		log.error(message, throwable);
	}

	public void error(Object message)
	{
		log.error(message);
	}

	public void info(Object message, Throwable throwable)
	{
		log.info(message, throwable);
	}

	public void info(Object message)
	{
		log.info(message);
	}

	public void warn(Object message, Throwable throwable)
	{
		log.warn(message, throwable);
	}

	public void warn(Object message)
	{
		log.warn(message);
	}

	public void fatal(Object message, Throwable throwable)
	{
		log.fatal(message, throwable);
	}

	public void fatal(Object message)
	{
		log.fatal(message);
	}

	public void log(int level, Object message, Throwable throwable)
	{
		switch (level) {

		case FATAL:
			log.fatal(message, throwable);
			return;
		case ERROR:
			log.error(message, throwable);
			return;
		case WARN:
			log.warn(message, throwable);
			return;
		case INFO:
			log.info(message, throwable);
			return;
		case DEBUG:
			log.debug(message, throwable);
			return;

		default:

		}
	}

	public void log(int level, String message, Throwable throwable)
	{

		switch (level) {

		case FATAL:
			log.fatal(message, throwable);
			return;

		case ERROR:
			log.error(message, throwable);
			return;

		case WARN:
			log.warn(message, throwable);
			return;

		case INFO:
			log.info(message, throwable);
			return;

		case DEBUG:
			log.debug(message, throwable);
			return;

		default:
		}
	}

	public void throwing(String string, Exception ex) {
		// TODO Auto-generated method stub
		
	}

	public void addHandler(FileHandler fh) {
		// TODO Auto-generated method stub
		
	}

	public static Handler getRootLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	

}



