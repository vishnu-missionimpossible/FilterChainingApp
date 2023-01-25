package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/test1")
public class LogFilter  implements Filter {
	private FilterConfig fConfig=null;
	
    static {
    	System.out.println("LogFilter loading...");
    }   
    
    public LogFilter() {
        System.out.println("LogFilet instantiation...");
    }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LogFilter initialization...");
		this.fConfig=fConfig;
	}
	

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 PrintWriter out = response.getWriter();
		 out.println("<h1>This line is added by the log filter before processing the request... <h1>");

		 
		 ServletContext context = fConfig.getServletContext();
		 HttpServletRequest req1 = (HttpServletRequest)(request);
		 
		 context.log("A request is coming from :: "+req1.getRemoteHost()+" for URL :: "+req1.getRequestURL()+" at Date :: "+new Date());
		 
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		out.println("<h1>This line is added by the log filter after processing the request... </h1>");
	}

	public void destroy() {
		fConfig = null;
		System.out.println("LogFilter De-Instantiation...");
	}
	

}
