/*
 * $Id$
 */
package de.itemis.faces.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;
import de.itemis.jee6.util.LogUtil;

@WebFilter(urlPatterns = {"/*"})
public class AutoLoginFilter implements Filter
{
	private static final Log  log    = LogFactory.getLog(AutoLoginFilter.class);
	private static final BASE64Decoder decoder = new BASE64Decoder();

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
	}

	@Override
	public void destroy()
	{
	}

	@Override
	public void doFilter(
			ServletRequest  request,
			ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		log.trace(">doFilter()");

		if (request instanceof HttpServletRequest)
		{
			HttpServletRequest r = (HttpServletRequest)request;
			
	        String basic = r.getHeader("authorization"); 
	        LogUtil.trace(log, " URI: %s", r.getRequestURI());
	        LogUtil.trace(log, " URL: %s", r.getRequestURL());
	        if ((basic != null) && basic.startsWith("Basic "))
	        {
	        	String principal = r.getRemoteUser();
	            if (principal == null)
	            {
	                String [] userdata = new String (decoder.decodeBuffer(basic.substring(6))).split(":");
	                final String user = userdata[0];
	
	                LogUtil.info(log, " Automatically logging in user %s.", user);
	            	r.login(userdata[0], userdata[1]);
	//            	HttpServletResponse resp = (HttpServletResponse)response;
	//            	resp.sendRedirect(r.getRequestURL().toString());
	            }
	        }
        }
//		else
        {
        	filter.doFilter(request, response);
        }
		log.trace("<doFilter()");
	}
}