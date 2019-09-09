package com.sampark.ctool.filter;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RequestFilter
 */
//@WebFilter("/login")
public class RequestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		 
		RequestDispatcher rd = request.getRequestDispatcher("/access/denied");
		 final HttpServletRequest req = (HttpServletRequest) request;
		 final   HttpServletResponse res = (HttpServletResponse) response;  
		 
		 InetAddress localhost = InetAddress.getLocalHost(); 
	        System.out.println("System IP Address : " + 
	                      (localhost.getHostAddress()).trim()); 
	        if(localhost.getHostAddress().trim().equalsIgnoreCase("192.168.10.112") || localhost.getHostAddress().trim().equalsIgnoreCase("103.240.91.180"))
	        {
	        	chain.doFilter(request, response);
	        }
	        else
	        {
	        	rd.forward(request, response);	
	        }
	            
	    }
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
