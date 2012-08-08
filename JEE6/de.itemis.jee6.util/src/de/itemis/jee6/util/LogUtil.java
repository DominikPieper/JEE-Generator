/*
 * $Id$
 */
package de.itemis.jee6.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;

public class LogUtil
{
	public final static String printf(final String format, final Object ... arguments)
	{
		final StringWriter sw = new StringWriter();
		final PrintWriter  pw = new PrintWriter(sw);
		
		pw.printf(format, arguments);
		final String result = sw.toString();
		
		pw.close();
		return result;
	}
	
	public final static void trace(final Log log, final String format, final Object ... arguments)
	{
		if (log.isTraceEnabled())
		{
			log.trace(printf(format, arguments));
		}
	}
	
	public final static void debug(final Log log, final String format, final Object ... arguments)
	{
		if (log.isDebugEnabled())
		{
			log.debug(printf(format, arguments));
		}
	}

	public final static void info(final Log log, final String format, final Object ... arguments)
	{
		if (log.isInfoEnabled())
		{
			log.info(printf(format, arguments));
		}
	}
	
	public final static void warn(final Log log, final String format, final Object ... arguments)
	{
		if (log.isWarnEnabled())
		{
			log.warn(printf(format, arguments));
		}
	}

	public final static void error(final Log log, final String format, final Object ... arguments)
	{
		if (log.isErrorEnabled())
		{
			log.error(printf(format, arguments));
		}
	}

	public final static String format(final String format, final Object ... arguments)
	{
		return MessageFormat.format(format, arguments);
	}
	
	public final static boolean isEmpty(final String input)
	{
		return (input == null) || input.trim().isEmpty();
	}
	
	public static String banner(final String key, final String product)
	{
		ResourceBundle bundle = ResourceBundle.getBundle(key);
		final String version = LogUtil.format("= {4} (C) {0} {1}.{2}.{3} =",
				bundle.getString("vendor"),
				bundle.getString("version.major"),
				bundle.getString("version.minor"),
				bundle.getString("version.patch"),
				product);
		StringBuffer buffer = new StringBuffer(version.length());
		for (int i = 0;i < version.length();i++)
		{
			buffer.append("=");
		}
		return buffer + "\n" + version + "\n" + buffer;
	}
}
