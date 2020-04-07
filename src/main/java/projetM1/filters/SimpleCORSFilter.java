package projetM1.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class SimpleCORSFilter implements Filter {

	    
	  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	      
	        HttpServletRequest request = (HttpServletRequest) servletRequest;
	        
	        // Authorize (allow) all domains to consume the content
	        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
	        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
	        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Content-Type, token, Access-Control-Allow-Headers, Authorization, X-Requested-With");
	        
	        HttpServletResponse resp = (HttpServletResponse) servletResponse;
	        
	        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
	        if (request.getMethod().equals("OPTIONS")) {
	            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
	            return;
	        }
	        
	        // pass the request along the filter chain
	        chain.doFilter(request, servletResponse);
	  }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	    
	}